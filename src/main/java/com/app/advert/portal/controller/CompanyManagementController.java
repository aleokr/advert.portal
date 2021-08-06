package com.app.advert.portal.controller;

import com.app.advert.portal.model.Company;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management/api/v1/companies")
@CrossOrigin
@RequiredArgsConstructor
public class CompanyManagementController {

    @PostMapping("/addCompany")
    @Operation(tags = {"Company management"}, description = "Register new company")
    @PreAuthorize("hasAuthority('COMPANY_USER')")
    public void registerNewCompany(@RequestBody Company company){
        System.out.println(company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    @Operation(tags = {"Company management"}, description = "Delete company")
    @PreAuthorize("hasAuthority('COMPANY_WRITE')")
    public void deleteCompany(@PathVariable("id") Integer companyId){
        System.out.println(companyId);
    }

    @PutMapping("/updateCompany/{id}")
    @Operation(tags = {"Company management"}, description = "Update company")
    @PreAuthorize("hasAuthority('COMPANY_WRITE')")
    public void updateCompany(@PathVariable("id") Integer companyId, @RequestBody Company company){
        System.out.println(companyId);
        System.out.println(company);
    }
}
