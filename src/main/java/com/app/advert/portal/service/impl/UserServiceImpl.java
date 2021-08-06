package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.UserDto;
import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public List<Role> getRolesByUserId(Long id) {
        return userMapper.getRolesAndPermissionsByUserId(id);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getSurname(), userDto.getEmail(), userDto.getLogin(), passwordEncoder.encode(userDto.getPassword()));
        userMapper.saveUser(user);
        userMapper.addRoleToUser(userDto.getUserRole().name(), user.getLogin());
    }

    @Override
    public void updateUser(UserDto userDto, Long userId) {
        User user = new User(userDto.getName(), userDto.getSurname(), userDto.getEmail(), userDto.getLogin(), userDto.getPassword());
        userMapper.updateUser(user, userId);
    }

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteUserRoles(userId);
        userMapper.deleteUserById(userId);
    }
}
