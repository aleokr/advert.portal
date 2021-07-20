package com.app.advert.portal.controller;

import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @Operation(tags = {"User"}, description = "Return all users")
	@GetMapping("/getAll")
    public List<User> getAll() {
        return userMapper.getAll();
    }
}