package com.app.advert.portal.controller;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationListResponse;
import com.app.advert.portal.model.Application;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.ApplicationService;
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
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;

    @Operation(tags = {"Application"}, description = "Return user applications")
    @GetMapping("/userApplications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationListResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getUserApplications(
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit) {
        try {
            ApplicationListRequest request = new ApplicationListRequest(limit, offset);
            log.info("ApplicationController: Return user applications");
            return ResponseEntity.ok().body(applicationService.getUserApplications(request, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Application"}, description = "Return responses to user adverts")
    @GetMapping("/userResponses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationListResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getResponsesToUserAdverts(
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit) {
        try {
            ApplicationListRequest request = new ApplicationListRequest(limit, offset);
            log.info("ApplicationController: Return responses to user adverts");
            return ResponseEntity.ok().body(applicationService.getResponsesToUserAdverts(request, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Application"}, description = "Save response to advert")
    @PostMapping("/save/{advertId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Błędne żądanie", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> saveResponseToAdvert(@PathVariable Long advertId) {
        try {
            log.info("ApplicationController: Save response to advert");
            Application application = applicationService.saveResponseToAdvert(advertId, SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId());
            if (application == null) {
                return ResponseEntity.badRequest().body("Application already exists!");
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
