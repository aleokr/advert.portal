package com.app.advert.portal.service;

import com.app.advert.portal.dto.UserDto;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    ResponseEntity getById(Long id);

    User getByUsername(String username);

    List<Role> getRolesByUserId(Long id);

    ResponseEntity saveUser(UserDto userDto);

    ResponseEntity updateUser(UserDto userDto, Long userId);

    ResponseEntity deleteUser(Long userId);
}
