package com.app.advert.portal.controller;

import com.app.advert.portal.dto.UserDto;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
@Api(value = "User management Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"User management"})
public class UserManagementController {

    private final UserService userService;

    @GetMapping("/getAll")
    @Operation(tags = {"User management"}, description = "Get all users")
    @PreAuthorize("hasAuthority('INDIVIDUAL_USER')")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/addUser")
    @Operation(tags = {"User management"}, description = "Register new user")
    public ResponseEntity registerNewUser(@RequestBody UserDto userDto) {
        try{
            log.debug("UserManagementController: Register new user");
            User user = userService.getByUsername(userDto.getLogin());
            if (user != null) {
                return ResponseEntity.unprocessableEntity().body("User with login " + user.getLogin() + " already exists");
            }
            return ResponseEntity.ok().body(userService.saveUser(userDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @DeleteMapping("/deleteUser/{id}")
    @Operation(tags = {"User management"}, description = "Delete user")
    @PreAuthorize("hasAuthority('USER_WRITE')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        try{
            if(!userId.equals(SecurityUtils.getLoggedUserId())){
                return new ResponseEntity<>("No permission to ", HttpStatus.FORBIDDEN);
            }
            log.debug("UserManagementController: Delete user: " + userId);
            userService.deleteUser(userId);
            return ResponseEntity.ok().body("User deleted!");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PutMapping("/updateUser/{id}")
    @Operation(tags = {"User management"}, description = "Update user")
    @PreAuthorize("hasAnyAuthority('USER_WRITE', 'COMPANY_USER')")
    public ResponseEntity updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        try{
            if(!userId.equals(SecurityUtils.getLoggedUserId())){
                return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
            }
            log.debug("UserManagementController: Update user: " + userId);
            return ResponseEntity.ok().body(userService.updateUser(userDto, userId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
