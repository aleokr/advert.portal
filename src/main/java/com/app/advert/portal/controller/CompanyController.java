package com.app.advert.portal.controller;

import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.Company;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/companies")
@CrossOrigin
@RequiredArgsConstructor
public class CompanyController {
    private final UserMapper userMapper;

    @Operation(tags = {"Company"}, description = "Get company by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER, COMPANY_USER')")
    public Company getById(@PathVariable Integer id) {
        return new Company(id, "Firma", "Opis");
    }
}
