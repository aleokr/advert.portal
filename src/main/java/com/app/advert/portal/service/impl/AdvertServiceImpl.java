package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.*;
import com.app.advert.portal.elasticsearch.service.ElasticAdvertService;
import com.app.advert.portal.elasticsearch.service.ElasticFileService;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.mapper.AdvertMapper;
import com.app.advert.portal.mapper.ApplicationMapper;
import com.app.advert.portal.mapper.FileMapper;
import com.app.advert.portal.mapper.TagMapper;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.File;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.AdvertService;
import com.app.advert.portal.service.ApplicationService;
import com.app.advert.portal.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertMapper advertMapper;

    private final TagMapper tagMapper;

    private final ApplicationMapper applicationMapper;

    private final ApplicationService applicationService;

    private final FileMapper fileMapper;

    private final FileService fileService;

    private final ElasticAdvertService elasticAdvertService;

    private final ElasticFileService elasticFileService;

    @Override
    public AdvertResponse getById(Long id, Long companyId, Long userId) {
        AdvertResponse advert = advertMapper.getAdvertInfoById(id);

        advert.setApplicationExists(applicationService.checkIfApplicationExists(id, companyId != null ? null : userId, companyId));
        advert.setCanEdit(advert.getOwnerId().equals(userId) || advert.getOwnerId().equals(companyId));
        advert.setCanApplicate(!advert.getApplicationExists() && !advert.getCanEdit()
                && ((advert.getAdvertType().equals(AdvertType.COMPANY) && !SecurityUtils.isCompanyUser()) || (advert.getAdvertType().equals(AdvertType.INDIVIDUAL) && SecurityUtils.isCompanyUser())));

        advert.setTags(tagMapper.getTagsByResourceIdAndType(id, ResourceType.ADVERT));

        List<FileResponse> files = fileService.getFilesDataByResourceId(advert.getId(), ResourceType.ADVERT);
        for (FileResponse fileResponse : files) {
            if (fileResponse.getFileType().equals(FileType.ATTACHMENT)) {
                advert.setMainFilePath(fileResponse.getFilePath());
            }
        }
        return advert;
    }

    @Override
    public AdvertListResponse getAdverts(AdvertListRequest request, Long companyId, Long userId) throws IOException {
        AdvertListResponse response = new AdvertListResponse();
        Integer totalCount = null;
        List<Long> advertIds = null;

        //wyszukiwanie pełnotekstowe lub wyszukiwanie na podstawie podobieństwa plików
        if (request.getSearchText() != null || request.isSimilarFiles()) {

            AdvertListElasticResponse elasticResponse;
            //wyszukiwanie na podstawie podobieństw plików "głównych"
            if (request.isSimilarFiles()) {
                List<FileResponse> files = fileService.getFilesDataByResourceId(companyId != null ? companyId : userId, companyId != null ? ResourceType.COMPANY : ResourceType.USER);
                FileResponse attachmentFile = files.stream().filter(file -> file.getFileType().equals(FileType.ATTACHMENT)).findFirst().orElse(null);
                if (attachmentFile != null) {
                    elasticResponse = elasticFileService.findSimilarFile(elasticFileService.getFileById(attachmentFile.getId()), request.getType(), request.getOffset(), request.getLimit());
                } else {
                    elasticResponse = new AdvertListElasticResponse(new HashSet<>(), 0L);
                }
            } else {
                elasticResponse = elasticAdvertService.getAdvertsWithText(request.getSearchText(), request.getType().name(), request.getLimit(), request.getOffset());
            }

            totalCount = (int) elasticResponse.getTotalCount();
            advertIds = new ArrayList<>(elasticResponse.getAdvertIds());

            if (advertIds.isEmpty()) {
                PagingResponse pagingResponse = new PagingResponse(request.getOffset() / request.getLimit(), (totalCount % request.getLimit() == 0) ? totalCount / request.getLimit() : totalCount / request.getLimit() + 1, totalCount);
                response.setPaging(pagingResponse);
                response.setAdverts(new ArrayList<>());
                return response;
            }

        } else {
            if (request.getType() == null) {
                request.setCompanyId(companyId);
                request.setUserId(companyId != null ? null : userId);
            }
            totalCount = advertMapper.getAdvertsCountByUser(request);
        }

        PagingResponse pagingResponse = new PagingResponse(request.getOffset() / request.getLimit(), (totalCount % request.getLimit() == 0) ? totalCount / request.getLimit() : totalCount / request.getLimit() + 1, totalCount);

        //gdy użytkownik jest zalogowany wyszukiwanie odbywa się po tagach, chyba, że użytkownik wyszukuje pełnotekstowo lub na podstawie podobieństwa plików
        if ((companyId != null || userId != null) && request.getType() != null && request.getSearchText() == null && !request.isSimilarFiles()) {
            List<Long> tagIds = tagMapper.getTagIdsByResourceIdAndType(companyId != null ? companyId : userId, companyId != null ? ResourceType.COMPANY : ResourceType.USER);
            response.setAdverts(advertMapper.getAdvertListByTags(request, tagIds));
        } else {
            response.setAdverts(advertMapper.getAdvertList(request, advertIds));
        }

        response.setPaging(pagingResponse);
        return response;
    }

    @Override
    public Advert saveAdvert(AdvertRequestDto advertRequestDto, Long companyId, Long userId) {
        AdvertType advertType = companyId != null ? AdvertType.COMPANY : AdvertType.INDIVIDUAL;
        Advert advert = new Advert(null, advertRequestDto.getTitle(), advertRequestDto.getShortDescription(),
                advertRequestDto.getLongDescription(), userId, advertRequestDto.getCategory(), advertType);

        //dodanie ogłoszenia
        advertMapper.saveAdvert(advert);

        advert = advertMapper.getById(advertMapper.lastAddAdvertId());

        if (advertRequestDto.getTagIds() != null && !advertRequestDto.getTagIds().isEmpty()) {
            //zapisanie tagów ogłoszenia
            for (Long tagId : advertRequestDto.getTagIds()) {
                tagMapper.saveResourceTag(advert.getId(), tagId, ResourceType.ADVERT);
            }
        }

        //dodawanie ogłoszenia do elasticsearch
        com.app.advert.portal.elasticsearch.document.Advert elasticAdvert = new com.app.advert.portal.elasticsearch.document.Advert(advert.getId(), advert.getTitle(), advert.getLongDescription(), advertType.name());
        elasticAdvertService.save(elasticAdvert);

        return advert;
    }

    @Override
    public Advert updateAdvert(AdvertRequestDto advertDto, Long companyId, Long userId) {

        if (noAccessToAdvert(advertDto.getId(), companyId, userId)) {
            return null;
        }

        AdvertType advertType = companyId != null ? AdvertType.COMPANY : AdvertType.INDIVIDUAL;

        Advert advert = advertMapper.getById(advertDto.getId());
        advert.setLongDescription(advertDto.getLongDescription());
        advert.setShortDescription(advertDto.getShortDescription());
        advert.setTitle(advertDto.getTitle());
        advertMapper.updateAdvert(advert);

        //aktualizacja ogłoszenia w elasticsearch (nadpisanie)
        com.app.advert.portal.elasticsearch.document.Advert elasticAdvert = new com.app.advert.portal.elasticsearch.document.Advert(advert.getId(), advert.getTitle(), advert.getLongDescription(), advertType.name());
        elasticAdvertService.save(elasticAdvert);

        return advertMapper.getById(advert.getId());
    }

    @Override
    public boolean deleteAdvert(Long advertId, Long companyId, Long userId) {
        if (noAccessToAdvert(advertId, companyId, userId)) {
            return false;
        }

        //usunięcie plików przypisanych do ogłoszenia
        List<File> files = fileMapper.getFilesByResourceId(advertId, ResourceType.ADVERT);
        for (File file : files) {
            fileService.deleteFile(null, file);
        }

        //usunięcie aplikacji
        applicationMapper.deleteApplicationByAdvertId(advertId);

        //usunięcie ogłoszenia z elasticsearch
        deleteFileFromElasticsearch(advertId);

        advertMapper.deleteAdvertById(advertId);
        return true;
    }

    @Override
    public Advert archivedAdvert(Long advertId, Long companyId, Long userId) {
        if (noAccessToAdvert(advertId, companyId, userId)) {
            return null;
        }

        advertMapper.archivedAdvert(advertId);

        //usunięcie ogłoszenia z elasticsearch
        deleteFileFromElasticsearch(advertId);

        return advertMapper.getById(advertId);
    }

    @Override
    public List<AdvertCategory> getAdvertCategories() {
        return advertMapper.getAdvertCategories();
    }


    private void deleteFileFromElasticsearch(Long advertId) {
        com.app.advert.portal.elasticsearch.document.Advert elasticAdvert = elasticAdvertService.findAdvertById(advertId.intValue());
        elasticAdvertService.delete(elasticAdvert);
    }

    private boolean noAccessToAdvert(Long advertId, Long companyId, Long userId) {
        if (advertId == null) return true;
        User user = advertMapper.getUserByAdvertId(advertId);
        return user == null || !user.getId().equals(userId) || (user.getCompanyId() != null && !user.getCompanyId().equals(companyId));
    }
}
