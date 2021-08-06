package com.app.advert.portal.controller;

import com.app.advert.portal.model.User;
import com.app.advert.portal.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @Operation(tags = {"User"}, description = "Get user by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER', 'COMPANY_USER')")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        log.debug("UserController: Get user by id: " + id);
        return ResponseEntity.ok().body(userService.getById(id));
    }

}