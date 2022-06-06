package com.app.advert.portal.controller;

import com.app.advert.portal.dto.FileDto;
import com.app.advert.portal.model.File;
import com.app.advert.portal.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileService fileService;

    @Operation(tags = {"File"}, description = "Save file")
    @PostMapping("/save")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = File.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> saveFile(FileDto fileDto) {
        try {
            log.info("FileController: Save new file");
            return ResponseEntity.ok().body(fileService.saveFile(fileDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"File"}, description = "Update file")
    @PatchMapping("/update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = File.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> updateFile(FileDto fileDto) {
        try {
            log.info("FileController: Update file");
            return ResponseEntity.ok().body(fileService.updateFile(fileDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"File"}, description = "Delete file")
    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        try {
            log.info("FileController: Delete file");
            fileService.deleteFile(id, null);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
