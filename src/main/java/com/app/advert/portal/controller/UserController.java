package com.app.advert.portal.controller;

import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Operation(tags = {"User"},
			description = "Return User")
	@GetMapping("/getUser")
    public User getAll() {
        return userMapper.getPersonById();
    }
}