package com.app.advert.portal.controller;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
@Slf4j
@Api(value = "Application Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Application"})
public class ApplicationController {

    private final ApplicationService applicationService;

    @Operation(tags = {"Application"}, description = "Return user applications")
    @GetMapping("/userApplications")
    public ResponseEntity<?> getUserApplications(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit) {
        try {
            ApplicationListRequest request = new ApplicationListRequest(userId, companyId, limit, offset);
            log.info("ApplicationController: Return user applications");
            return applicationService.getUserApplications(request);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Application"}, description = "Return responses to user adverts")
    @GetMapping("/userResponses")
    public ResponseEntity<?> getResponsesToUserAdverts(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit) {
        try {
            ApplicationListRequest request =  new ApplicationListRequest(userId, companyId, limit, offset);
            log.info("ApplicationController: Return responses to user adverts");
            return applicationService.getResponsesToUserAdverts(request);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Operation(tags = {"Application"}, description = "Save response to advert")
    @PostMapping("/save/{advertId}")
    public ResponseEntity<?> saveResponseToAdvert(@PathVariable Long advertId) {
        try {
            log.info("ApplicationController: Save response to advert");
            return applicationService.saveResponseToAdvert(advertId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
