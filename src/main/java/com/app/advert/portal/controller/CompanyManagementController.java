package com.app.advert.portal.controller;

import com.app.advert.portal.dto.CompanyRequestDto;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.model.Company;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.CompanyService;
import com.app.advert.portal.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management/api/v1/companies")
@RequiredArgsConstructor
@Slf4j
public class CompanyManagementController {

    private final CompanyService companyService;

    private final UserService userService;

    @PostMapping("/addCompany")
    @Operation(tags = {"Company management"}, description = "Register new company")
    @PreAuthorize("hasAuthority('COMPANY_ADMIN')")
    public ResponseEntity<?> registerNewCompany(@Validated @RequestBody CompanyRequestDto companyDto) {
        try {
            log.info("CompanyController: Register new company");
            User user = userService.getBasicUserDataById(SecurityUtils.getLoggedUserId());

            if (user.getCompanyId() != null || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_ADMIN.name()))) {
                return ResponseEntity.badRequest().body("User has already a company or hasn't access to create a company");
            }
            Company company = companyService.saveCompany(companyDto, user.getId());
            if (company == null) {
                return ResponseEntity.unprocessableEntity().body("Company with name " + companyDto.getName() + " already exists");
            }

            return ResponseEntity.ok().body(company);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @DeleteMapping("{id}")
    @Operation(tags = {"Company management"}, description = "Delete company")
    @PreAuthorize("hasAuthority('COMPANY_ADMIN')")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") Long companyId) {
        try {
            log.info("CompanyController: Delete company with id: " + companyId);
            User user = userService.getBasicUserDataById(SecurityUtils.getLoggedUserId());

            if (!user.getCompanyId().equals(companyId) || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_USER.name()))) {
                return ResponseEntity.badRequest().body("No access to resource");
            }
            companyService.deleteCompany(companyId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PutMapping("/update")
    @Operation(tags = {"Company management"}, description = "Update company")
    @PreAuthorize("hasAuthority('COMPANY_ADMIN')")
    public ResponseEntity<?> updateCompany(@Validated @RequestBody CompanyRequestDto companyDto) {
        try {
            log.info("CompanyController: Update company with id: " + companyDto.getId());
            User user = userService.getBasicUserDataById(SecurityUtils.getLoggedUserId());

            if (user.getCompanyId() != null || user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.COMPANY_ADMIN.name()))) {
                return ResponseEntity.badRequest().body("User has already a company or hasn't access to create a company");
            }
            if (companyService.getBasicCompanyDataByName(companyDto.getName()) == null) {
                return ResponseEntity.unprocessableEntity().body("Company with name " + companyDto.getName() + " not exists");
            }

            return ResponseEntity.ok().body(companyService.updateCompany(companyDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
