package com.app.advert.portal.controller;

import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j

public class UserController {

    private final UserService userService;

    @Operation(tags = {"User"}, description = "Get user by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INDIVIDUAL_USER', 'COMPANY_USER', 'COMPANY_ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            log.info("UserController: Get user by id: " + id);
            return ResponseEntity.ok().body(userService.getById(id, id.equals(SecurityUtils.getLoggedUserId()) ? SecurityUtils.getLoggedCompanyId() : null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @Operation(tags = {"User"}, description = "Get user roles")
    @GetMapping("/roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Role.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getUserRoles() {
        try {
            log.info("UserController: Get user roles");
            return ResponseEntity.ok().body(userService.getUserRoles());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @Operation(tags = {"User"}, description = "Get user by token")
    @GetMapping("/loggedUser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> getLoggedUserInfo() {
        try {
            log.info("UserController: Get user by token");
            return ResponseEntity.ok().body(userService.getLoggedUserInfo(SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}