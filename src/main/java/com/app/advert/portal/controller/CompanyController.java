package com.app.advert.portal.controller;

import com.app.advert.portal.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/companies")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
@Api(value = "Company Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Company"})
public class CompanyController {

    private final CompanyService companyService;

    @Operation(tags = {"Company"}, description = "Get company by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER, COMPANY_USER')")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            log.debug("CompanyController: Get company by id: " + id);
            return companyService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }
}
