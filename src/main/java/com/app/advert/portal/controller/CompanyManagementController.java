package com.app.advert.portal.controller;

import com.app.advert.portal.dto.CompanyDto;
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
@RequestMapping("/management/api/v1/companies")
@RequiredArgsConstructor
@Slf4j
@Api(value = "Company management Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Company management"})
public class CompanyManagementController {

    private final CompanyService companyService;

    @PostMapping("/addCompany")
    @Operation(tags = {"Company management"}, description = "Register new company")
    @PreAuthorize("hasAuthority('COMPANY_USER')")
    public ResponseEntity<?> registerNewCompany(@RequestBody CompanyDto companyDto) {
        try {
            log.info("CompanyController: Register new company");
            return companyService.saveCompany(companyDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @DeleteMapping("{id}")
    @Operation(tags = {"Company management"}, description = "Delete company")
    @PreAuthorize("hasAuthority('COMPANY_WRITE')")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") Long companyId) {
        try {
            log.info("CompanyController: Delete company with id: " + companyId);
            return companyService.deleteCompany(companyId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PutMapping("/update")
    @Operation(tags = {"Company management"}, description = "Update company")
    @PreAuthorize("hasAuthority('COMPANY_WRITE')")
    public ResponseEntity<?> updateCompany(@RequestBody CompanyDto companyDto) {
        try {
            log.info("CompanyController: Update company with id: " + companyDto.getId());
            return companyService.updateCompany(companyDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
