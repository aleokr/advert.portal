package com.app.advert.portal.controller;

import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@Slf4j
@Api(value = "File Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"File"})
public class FileController {

    private final FileService fileService;

    @Operation(tags = {"File"}, description = "Save file")
    @PostMapping("/save")
    public ResponseEntity<?> saveFile(FileDto fileDto) {
        try {
            log.info("FileController: Save new file");
            return fileService.saveFile(fileDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"File"}, description = "Update file")
    @PatchMapping("/update")
    public ResponseEntity<?> updateFile(FileDto fileDto) {
        try {
            log.info("FileController: Update file");
            return fileService.updateFile(fileDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"File"}, description = "Delete file")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        try {
            log.info("FileController: Delete file");
            return fileService.deleteFile(id, null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
