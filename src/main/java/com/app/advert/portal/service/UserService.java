package com.app.advert.portal.service;

import com.app.advert.portal.dto.UserListRequest;
import com.app.advert.portal.dto.UserRequestDto;
import com.app.advert.portal.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseEntity<?> getById(Long id);

    User getByUsername(String username);

    ResponseEntity<?>  saveUser(UserRequestDto userDto);

    ResponseEntity<?>  updateUser(UserRequestDto userDto);

    ResponseEntity<?>  deleteUser(Long userId);

    ResponseEntity<?>  getUsers(UserListRequest userListRequest);

    ResponseEntity<?> activateUser(Long userId);
}
