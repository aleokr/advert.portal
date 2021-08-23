package com.app.advert.portal.controller;

import com.app.advert.portal.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
@Api(value = "User Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"User"})

public class UserController {

    private final UserService userService;

    @Operation(tags = {"User"}, description = "Get user by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER', 'COMPANY_USER', 'COMPANY_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            log.info("UserController: Get user by id: " + id);
            return userService.getById(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

}