package com.app.advert.portal.controller;

import com.app.advert.portal.dto.UserListRequest;
import com.app.advert.portal.dto.UserRequestDto;
import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/management/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserManagementController {

    private final UserService userService;

    @PostMapping("/addUser")
    @Operation(tags = {"User management"}, description = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "422", description = "Niekompletne żądanie", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> registerNewUser(@Validated @RequestBody UserRequestDto userDto) {
        try {
            log.info("UserManagementController: Register new user");

            if (userDto.getPassword() == null) {
                return ResponseEntity.unprocessableEntity().body("No password ");
            }

            User user = userService.saveUser(userDto);
            if (user == null) {
                return ResponseEntity.unprocessableEntity().body("User with login " + user.getLogin() + " already exists");
            }
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    @Operation(tags = {"User management"}, description = "Delete user")
    @PreAuthorize("hasAnyAuthority('USER_WRITE', 'COMPANY_ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        try {
            log.info("UserManagementController: Delete user: " + userId);

            User user = userService.getBasicUserDataById(userId);
            if (!user.getId().equals(SecurityUtils.getLoggedUserId()) && (!SecurityUtils.isUserCompanyAdmin() && user.getCompanyId().equals(SecurityUtils.getLoggedCompanyId()))) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            userService.deleteUser(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PutMapping("/update")
    @Operation(tags = {"User management"}, description = "Update user")
    @PreAuthorize("hasAnyAuthority('USER_WRITE', 'COMPANY_USER', 'COMPANY_ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> updateUser(@Validated @RequestBody UserRequestDto userDto) {
        try {
            log.info("UserManagementController: Update user: " + userDto.getId());
            if (!userDto.getId().equals(SecurityUtils.getLoggedUserId())) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().body(userService.updateUser(userDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    @Operation(tags = {"User management"}, description = "List of users")
    @PreAuthorize("hasAnyAuthority('COMPANY_ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> readUsersList(
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) Long offset,
            @RequestParam(required = false) Long limit
    ) {
        try {
            UserListRequest userListRequest = new UserListRequest(companyId, offset, limit, active);
            log.info("UserManagementController: List of users");
            if (userListRequest.getCompanyId() != null && !userListRequest.getCompanyId().equals(SecurityUtils.getLoggedCompanyId())) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            return ResponseEntity.ok().body(userService.getUsers(userListRequest, SecurityUtils.getLoggedUserId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/activate/{userId}")
    @Operation(tags = {"User management"}, description = "Activate user")
    @PreAuthorize("hasAnyAuthority('COMPANY_ADMIN')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dane poprawnie przetworzone", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Brak dostępu do zasobu", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Błąd generowania odpowiedzi", content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<?> activateUser(@PathVariable Long userId) {
        try {
            log.info("UserManagementController: Activate user " + userId);
            User user = userService.getBasicUserDataById(userId);
            if (!user.getCompanyId().equals(SecurityUtils.getLoggedCompanyId())) {
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            userService.activateUser(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
