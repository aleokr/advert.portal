package com.app.advert.portal.service;

import com.app.advert.portal.dto.UserListRequest;
import com.app.advert.portal.dto.UserRequestDto;
import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public interface UserService {

    UserResponse getById(Long userId, Long companyId);

    User getByUsername(String username);

    User getBasicUserDataById(Long id);

    User saveUser(UserRequestDto userDto) throws IOException;

    User updateUser(UserRequestDto userDto);

    void deleteUser(Long userId);

    List<UserResponse> getUsers(UserListRequest userListRequest);

    void activateUser(Long userId);

    List<Role> getUserRoles();

    UserResponse getLoggedUserInfo(Long companyId, Long userId);
}
