package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.UserDto;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getById(Long id) {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());
        if (user.getRoles().stream().noneMatch(role -> role.getName().equals(UserRole.INDIVIDUAL_USER.name())) && user.getCompanyId() != id) {
            return ResponseEntity.badRequest().body("No access to resource");
        }
        return ResponseEntity.ok().body(userMapper.getById(id));
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
    public ResponseEntity saveUser(UserDto userDto) {

        User user = getByUsername(userDto.getLogin());
        if (user != null) {
            return ResponseEntity.unprocessableEntity().body("User with login " + user.getLogin() + " already exists");
        }

        User userToSave = new User(null, userDto.getName(), userDto.getSurname(), userDto.getEmail(),
                userDto.getLogin(), passwordEncoder.encode(userDto.getPassword()), null, null);
        userMapper.saveUser(userToSave);
        userMapper.addRoleToUser(userDto.getUserRole().name(), userToSave.getLogin());

        return ResponseEntity.ok().body(getByUsername(userToSave.getLogin()));
    }

    @Override
    public ResponseEntity updateUser(UserDto userDto, Long userId) {

        if(!userId.equals(SecurityUtils.getLoggedUserId())){
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        User user = new User(userDto.getName(), userDto.getSurname(), userDto.getEmail());
        userMapper.updateUser(user, userId);

        return ResponseEntity.ok().body(userMapper.getById(userId));
    }

    @Override
    public ResponseEntity deleteUser(Long userId) {

        if(!userId.equals(SecurityUtils.getLoggedUserId())){
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        userMapper.deleteUserRoles(userId);
        userMapper.deleteUserById(userId);

        return ResponseEntity.ok().build();
    }
}
