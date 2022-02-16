package com.app.advert.portal.service;

import com.app.advert.portal.dto.AdvertListResponse;
import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.dto.AdvertResponse;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.model.Advert;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public interface AdvertService {

    AdvertResponse getById(Long id, Long companyId, Long userId);

    AdvertListResponse getAdverts(AdvertListRequest request, Long companyId, Long userId) throws IOException;

    Advert saveAdvert(AdvertRequestDto advertRequestDto, Long companyId, Long userId) throws IOException;

    Advert updateAdvert(AdvertRequestDto advertRequestDto, Long companyId, Long userId);

    boolean deleteAdvert(Long advertId, Long companyId, Long userId);

    Advert archivedAdvert(Long advertId, Long companyId, Long userId);

    List<AdvertCategory> getAdvertCategories();
}
