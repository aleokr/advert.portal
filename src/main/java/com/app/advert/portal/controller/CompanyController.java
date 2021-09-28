package com.app.advert.portal.controller;

import com.app.advert.portal.dto.CompanyListRequest;
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
@RequiredArgsConstructor
@Slf4j
@Api(value = "Company Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Company"})
public class CompanyController {

    private final CompanyService companyService;

    @Operation(tags = {"Company"}, description = "Get company by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER', 'COMPANY_USER', 'COMPANY_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            log.info("CompanyController: Get company by id: " + id);
            return companyService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @Operation(tags = {"Company"}, description = "Return companies list")
    @GetMapping("/list")
    public ResponseEntity<?> getCompaniesList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long offset,
            @RequestParam(required = false) Long limit
    ) {
        try {
            CompanyListRequest companyListRequest = CompanyListRequest.builder()
                    .name(name)
                    .offset(offset)
                    .limit(limit)
                    .build();
            log.info("CompanyController: Return companies list");
            return companyService.companiesList(companyListRequest);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @Operation(tags = {"Company"}, description = "Get logged user company")
    @GetMapping("/")
    public ResponseEntity<?> getLoggedUserCompany() {
        try {
            log.info("CompanyController: Get logged user company");
            return companyService.getLoggedUserCompany();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }
}
