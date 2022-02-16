package com.app.advert.portal.service;

import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.dto.FileResponse;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.model.File;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FileService {

    File saveFile(FileDto fileDto) throws IOException;

    File updateFile(FileDto fileDto) throws IOException;

    void deleteFile(Long id, File file);

    List<FileResponse> getFilesDataByResourceId(Long resourceId, ResourceType resourceType);
}
