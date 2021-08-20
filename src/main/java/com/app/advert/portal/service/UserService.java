package com.app.advert.portal.service;

import com.app.advert.portal.dto.UserDto;
import com.app.advert.portal.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseEntity<?> getById(Long id);

    User getByUsername(String username);

    ResponseEntity<?>  saveUser(UserDto userDto);

    ResponseEntity<?>  updateUser(UserDto userDto);

    ResponseEntity<?>  deleteUser(Long userId);
}
