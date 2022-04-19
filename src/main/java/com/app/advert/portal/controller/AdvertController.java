package com.app.advert.portal.controller;

import com.app.advert.portal.dto.AdvertListResponse;
import com.app.advert.portal.dto.AdvertRequestDto;
import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.dto.AdvertResponse;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.enums.AdvertType;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.AdvertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/adverts")
@RequiredArgsConstructor
@Slf4j
public class AdvertController {

    private final AdvertService advertService;

    @Operation(tags = {"Advert"}, description = "Return adverts list")
    @GetMapping("/getAdverts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AdvertListResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getAdverts(
            @RequestParam Integer offset,
            @RequestParam Integer limit,
            @RequestParam AdvertType type,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long companyId,
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AdvertResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Advert.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Advert.class))}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> updateAdvert(@Validated @RequestBody AdvertRequestDto advertRequestDto) {
        try {
            log.info("AdvertController: Update advert: " + advertRequestDto.getId());
            Advert advert = advertService.updateAdvert(advertRequestDto, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if (advert == null) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().body(advert);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Archived advert")
    @PutMapping("/archive/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Advert.class))}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> archivedAdvert(@PathVariable Long id) {
        try {
            log.debug("AdvertController: Archived advert: " + id);

            Advert advert = advertService.archivedAdvert(id, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if (advert == null) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().body(advert);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Delete advert")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> deleteAdvert(@PathVariable Long id) {
        try {
            log.debug("AdvertController: Delete advert: " + id);
            boolean deleted = advertService.deleteAdvert(id, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if (!deleted) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Advert"}, description = "Return categories of adverts")
    @GetMapping("/categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AdvertCategory.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getAdvertCategories() {
        try {
            log.info("AdvertController: Return categories of adverts");
            return ResponseEntity.ok().body(advertService.getAdvertCategories());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
