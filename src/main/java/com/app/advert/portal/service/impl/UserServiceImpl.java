package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.dto.UserListRequest;
import com.app.advert.portal.dto.UserRequestDto;
import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.enums.TagType;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.mapper.AdvertMapper;
import com.app.advert.portal.mapper.ApplicationMapper;
import com.app.advert.portal.mapper.TagMapper;
import com.app.advert.portal.mapper.UserMapper;
import com.app.advert.portal.model.User;
import com.app.advert.portal.security.SecurityUtils;
import com.app.advert.portal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final AdvertMapper advertMapper;

    private final ApplicationMapper applicationMapper;

    private final TagMapper tagMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> getById(Long id) {
        User user = userMapper.getById(id);
        return getUserStatistics(user);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public ResponseEntity<?> saveUser(UserRequestDto userDto) {

        User user = getByUsername(userDto.getLogin());
        if (user != null) {
            return ResponseEntity.unprocessableEntity().body("User with login " + user.getLogin() + " already exists");
        }
        if (userDto.getPassword() == null) {
            return ResponseEntity.unprocessableEntity().body("No password ");
        }

        User userToSave = new User(null, userDto.getName(), userDto.getSurname(), userDto.getEmail(),
                userDto.getLogin(), passwordEncoder.encode(userDto.getPassword()), userDto.getCompanyId(), userDto.getUserRole(), null, userDto.getUserRole().equals(UserRole.INDIVIDUAL_USER) || userDto.getUserRole().equals(UserRole.COMPANY_ADMIN));
        userMapper.saveUser(userToSave);
        userMapper.addRoleToUser(userDto.getUserRole().name(), userToSave.getLogin());

        return ResponseEntity.ok().body(getByUsername(userToSave.getLogin()));
    }

    @Override
    public ResponseEntity<?> updateUser(UserRequestDto userDto) {
        if (!userDto.getId().equals(SecurityUtils.getLoggedUserId())) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        User user = new User(userDto.getId(), userDto.getName(), userDto.getSurname(), userDto.getEmail(), userDto.getPassword() != null ? passwordEncoder.encode(userDto.getPassword()) : null);
        userMapper.updateUser(user);

        return ResponseEntity.ok().body(userMapper.getById(user.getId()));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        User user = userMapper.getById(userId);
        if (!user.getId().equals(SecurityUtils.getLoggedUserId()) && (!SecurityUtils.isUserCompanyAdmin() && user.getCompanyId().equals(SecurityUtils.getLoggedCompanyId()))) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }

        userMapper.deleteUserRoles(userId);
        userMapper.deleteUserById(userId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getUsers(UserListRequest userListRequest) {
        if (userListRequest.getCompanyId() != null && !userListRequest.getCompanyId().equals(SecurityUtils.getLoggedCompanyId())) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok().body(userMapper.getUserList(userListRequest, SecurityUtils.getLoggedUserId()));
    }

    @Override
    public ResponseEntity<?> activateUser(Long userId) {
        User user = userMapper.getById(userId);
        if (!user.getCompanyId().equals(SecurityUtils.getLoggedCompanyId())) {
            return new ResponseEntity<>("No access to resource ", HttpStatus.FORBIDDEN);
        }
        userMapper.activateUser(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getUserRoles() {
        return ResponseEntity.ok().body(userMapper.getUserRoles());
    }

    @Override
    public ResponseEntity<?> getLoggedUserInfo() {
        User user = userMapper.getById(SecurityUtils.getLoggedUserId());
        return getUserStatistics(user);
    }

    private ResponseEntity<?> getUserStatistics(User user) {
        Integer advertsCount = advertMapper.getAdvertsCountByUser(AdvertListRequest.builder().companyId(SecurityUtils.getLoggedCompanyId()).userId(SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId()).build());
        Integer responsesCount = applicationMapper.getResponsesCountByUser(SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId());
        Integer applicationsCount = applicationMapper.getApplicationsCountByUser(SecurityUtils.getLoggedCompanyId(), SecurityUtils.getLoggedCompanyId() != null ? null : SecurityUtils.getLoggedUserId());

        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail(),
                user.getLogin(), user.getCompanyId(), user.getActive(), user.getType(), advertsCount, responsesCount, applicationsCount,
                tagMapper.getTagsByResourceIdAndType(SecurityUtils.getLoggedCompanyId() != null ? SecurityUtils.getLoggedCompanyId() : SecurityUtils.getLoggedUserId(), SecurityUtils.getLoggedCompanyId() != null ? TagType.COMPANY : TagType.USER));
        return ResponseEntity.ok().body(userResponse);
    }
}
