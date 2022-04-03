package com.app.advert.portal.service.impl;

import com.app.advert.portal.dto.*;
import com.app.advert.portal.enums.FileType;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.enums.UserRole;
import com.app.advert.portal.mapper.*;
import com.app.advert.portal.model.File;
import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import com.app.advert.portal.service.FileService;
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

    private final AdvertMapper advertMapper;

    private final ApplicationMapper applicationMapper;

    private final TagMapper tagMapper;

    private final PasswordEncoder passwordEncoder;

    private final FileMapper fileMapper;

    private final FileService fileService;

    @Override
    public UserResponse getById(Long userId, Long companyId) {
        User user = userMapper.getById(userId);
        return getAdditionalUserData(user, companyId, userId);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public User getBasicUserDataById(Long id) {
        return userMapper.getBasicUserDataById(id);
    }

    @Override
    public User saveUser(UserRequestDto userDto) {
        User user = getByUsername(userDto.getLogin());
        if(user != null) {
            return null;
        }
        User userToSave = new User(null, userDto.getName(), userDto.getSurname(), userDto.getEmail(),
                userDto.getLogin(), passwordEncoder.encode(userDto.getPassword()), userDto.getUserRole().equals(UserRole.COMPANY_USER) ? userDto.getCompanyId() : null, userDto.getUserRole(), null, userDto.getUserRole().equals(UserRole.INDIVIDUAL_USER) || userDto.getUserRole().equals(UserRole.COMPANY_ADMIN));
        userMapper.saveUser(userToSave);
        userMapper.addRoleToUser(userDto.getUserRole().name(), userToSave.getLogin());

        return getByUsername(userToSave.getLogin());
    }

    @Override
    public User updateUser(UserRequestDto userDto) {
        User user = new User(userDto.getId(), userDto.getName(), userDto.getSurname(), userDto.getEmail(), userDto.getPassword() != null ? passwordEncoder.encode(userDto.getPassword()) : null);
        userMapper.updateUser(user);

        return userMapper.getById(user.getId());
    }

    @Override
    public void deleteUser(Long userId) {
        //usunięcie plików przypisanych do użytkownika
        List<File> files = fileMapper.getFilesByResourceId(userId, ResourceType.USER);
        for (File file : files) {
            fileService.deleteFile(null, file);
        }

        userMapper.deleteUserRoles(userId);
        userMapper.deleteUserById(userId);
    }

    @Override
    public List<UserResponse> getUsers(UserListRequest userListRequest, Long userId) {
        return userMapper.getUserList(userListRequest, userId);
    }

    @Override
    public void activateUser(Long userId) {
        userMapper.activateUser(userId);
    }

    @Override
    public List<Role>  getUserRoles() {
        return userMapper.getUserRoles();
    }

    @Override
    public UserResponse getLoggedUserInfo(Long companyId, Long userId) {
        User user = userMapper.getById(userId);
        return getAdditionalUserData(user, companyId, userId);
    }

    private UserResponse getAdditionalUserData(User user, Long companyId, Long userId) {
        Integer advertsCount = advertMapper.getAdvertsCountByUser(AdvertListRequest.builder().companyId(companyId).userId(companyId != null ? null : userId).build());
        Integer responsesCount = applicationMapper.getResponsesCountByUser(companyId, companyId != null ? null : userId);
        Integer applicationsCount = applicationMapper.getApplicationsCountByUser(companyId, companyId != null ? null : userId);

        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail(),
                user.getLogin(), user.getCompanyId(), user.getActive(), user.getType(), advertsCount, responsesCount, applicationsCount,
                tagMapper.getTagsByResourceIdAndType(companyId != null ? companyId : userId, companyId != null ? ResourceType.COMPANY : ResourceType.USER), null, null);

        List<FileResponse> files = fileService.getFilesDataByResourceId(user.getId(), ResourceType.USER);
        for (FileResponse fileResponse : files) {
            if (fileResponse.getFileType().equals(FileType.ATTACHMENT)) {
                userResponse.setMainFilePath(fileResponse.getFilePath());
            } else {
                userResponse.setImagePath(fileResponse.getFilePath());
            }
        }
        return userResponse;
    }
}
