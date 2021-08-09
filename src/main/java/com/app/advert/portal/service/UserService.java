package com.app.advert.portal.service;

import com.app.advert.portal.dto.UserDto;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List <User> getAll();

    User getById(Long id);

    User getByUsername(String username);

    List<Role> getRolesByUserId(Long id);

    User saveUser(UserDto userDto);

    User updateUser(UserDto userDto, Long userId);

    void deleteUser(Long userId);
}
