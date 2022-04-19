package com.app.advert.portal.controller;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    @Operation(tags = {"Company"}, description = "Get company by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER', 'COMPANY_USER', 'COMPANY_ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            log.info("CompanyController: Get company by id: " + id);
            return ResponseEntity.ok().body(companyService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @Operation(tags = {"Company"}, description = "Return companies list")
    @GetMapping("/list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getCompaniesList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long offset,
            @RequestParam(required = false) Long limit
    ) {
        try {
            CompanyListRequest companyListRequest = new CompanyListRequest(name, offset, limit);
            log.info("CompanyController: Return companies list");
            return ResponseEntity.ok().body(companyService.companiesList(companyListRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @Operation(tags = {"Company"}, description = "Get logged user company")
    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CompanyResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Błędne żądanie", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getLoggedUserCompany() {
        try {
            log.info("CompanyController: Get logged user company");
            if (SecurityUtils.getLoggedCompanyId() == null) {
                return ResponseEntity.badRequest().body("No company id!");
            }
            return ResponseEntity.ok().body(companyService.getLoggedUserCompany(SecurityUtils.getLoggedCompanyId(), SecurityUtils.isUserCompanyAdmin()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }
}
