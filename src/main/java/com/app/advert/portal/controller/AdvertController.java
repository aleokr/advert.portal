package com.app.advert.portal.controller;

import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.service.AdvertService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/adverts")
@RequiredArgsConstructor
@Slf4j
@Api(value = "Advert Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Advert"})
public class AdvertController {

    private final AdvertService advertService;

    @Operation(tags = {"Advert"}, description = "Return adverts list")
    @GetMapping("/getAdverts")
    public ResponseEntity<?> getAdverts(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) Long offset,
            @RequestParam(required = false) Long limit,
            @RequestParam AdvertType type) {
        try {
            AdvertListRequest advertListRequest = AdvertListRequest.builder()
                    .id(id)
                    .userId(userId)
                    .companyId(companyId)
                    .offset(offset)
                    .limit(limit)
                    .type(type)
                    .build();

            log.info("AdvertController: Get adverts list");
            return advertService.getAdverts(advertListRequest);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Return advert by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getAdvertById(@PathVariable Long id) {
        try {
            log.info("AdvertController: Get advert by id");
            return advertService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Save advert")
    @PostMapping("/save")
    public ResponseEntity<?> saveAdvert(@Validated @RequestBody AdvertRequestDto advertRequestDto) {
        try {
            log.info("AdvertController: Save new advert");
            return advertService.saveAdvert(advertRequestDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Update advert")
    @PutMapping("/update")
    public ResponseEntity<?> updateAdvert(@Validated @RequestBody AdvertRequestDto advertRequestDto) {
        try {
            log.info("AdvertController: Update advert: " + advertRequestDto.getId());
            return advertService.updateAdvert(advertRequestDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Archived advert")
    @PutMapping("/archived/{id}")
    public ResponseEntity<?> archivedAdvert(@PathVariable Long id) {
        try {
            log.debug("AdvertController: Archived advert: " + id);
            return advertService.archivedAdvert(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Archived advert")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdvert(@PathVariable Long id) {
        try {
            log.debug("AdvertController: Delete advert: " + id);
            return advertService.deleteAdvert(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
