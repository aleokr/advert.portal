package com.app.advert.portal.controller;

import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.AdvertService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) AdvertType type,
            @RequestParam(required = false) String searchText,
            @RequestParam(required = false) boolean similarFiles) {
        try {
            AdvertListRequest advertListRequest = new AdvertListRequest(id, userId, companyId, offset, limit, type, searchText, similarFiles);
            log.info("AdvertController: Get adverts list");
            return ResponseEntity.ok().body(advertService.getAdverts(advertListRequest, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Return advert by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getAdvertById(@PathVariable Long id) {
        try {
            log.info("AdvertController: Get advert by id");
            return ResponseEntity.ok().body(advertService.getById(id, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Save advert")
    @PostMapping("/save")
    public ResponseEntity<?> saveAdvert(@Validated @RequestBody AdvertRequestDto advertRequestDto) {
        try {
            log.info("AdvertController: Save new advert");
            return ResponseEntity.ok().body(advertService.saveAdvert(advertRequestDto, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Update advert")
    @PutMapping("/update")
    public ResponseEntity<?> updateAdvert(@Validated @RequestBody AdvertRequestDto advertRequestDto) {
        try {
            log.info("AdvertController: Update advert: " + advertRequestDto.getId());
            Advert advert = advertService.updateAdvert(advertRequestDto, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if(advert == null) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().body(advert);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Archived advert")
    @PutMapping("/archive/{id}")
    public ResponseEntity<?> archivedAdvert(@PathVariable Long id) {
        try {
            log.debug("AdvertController: Archived advert: " + id);

            Advert advert =  advertService.archivedAdvert(id, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if(advert == null) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().body(advert);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Delete advert")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdvert(@PathVariable Long id) {
        try {
            log.debug("AdvertController: Delete advert: " + id);
            boolean deleted = advertService.deleteAdvert(id, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if(!deleted){
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Return categories of adverts")
    @GetMapping("/categories")
    public ResponseEntity<?> getAdvertCategories() {
        try {
            log.info("AdvertController: Return categories of adverts");
            return ResponseEntity.ok().body(advertService.getAdvertCategories());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
