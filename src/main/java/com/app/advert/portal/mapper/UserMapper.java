package com.app.advert.portal.mapper;

import com.app.advert.portal.model.Role;
import com.app.advert.portal.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<User> getAll();

    @Select("SELECT id, name, surname, email, login, created_at from USERS where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "email", column = "email"),
            @Result(property = "login", column = "login"),
            @Result(property = "roles", javaType = List.class, column = "id", many = @Many(select = "getRoleByUserId"))})
    User getById(Long id);

    @Select("SELECT r.id, r.name FROM ROLES r JOIN USER_ROLE ur ON ur.role_id = r.id WHERE ur.user_id=#{id}")
    Role getRoleByUserId(Long id);

    @Select("SELECT id, name, surname, email, login, password, created_at from USERS where login=#{username}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "email", column = "email"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "roles", javaType = List.class, column = "id", many = @Many(select = "getRoleByUserId"))})
    User getByUsername(String username);

    @Select("SELECT r.id, r.name FROM ROLES r JOIN USER_ROLE ur ON ur.role_id = r.id WHERE ur.user_id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "permissions", javaType = List.class, column = "id", many = @Many(select = "getPermissionByRoleId"))})
    List<Role> getRolesAndPermissionsByUserId(Long id);

    @Insert("INSERT INTO USERS(name, surname, email, login, password, created_at) values (#{name},#{surname},#{email},#{login},#{password}, now())")
    void saveUser(User user);

    @Update("UPDATE USERS SET name = #{user.name}, surname = #{user.surname}, email = #{user.email} where id = #{userId}")
    void updateUser(User user, Long userId);

    @Insert("INSERT INTO USER_ROLE(role_id, user_id) values ((SELECT id FROM ROLES WHERE name = #{roleName}),(SELECT id FROM USERS WHERE login = #{username}))")
    void addRoleToUser(String roleName, String username);

    @Delete("DELETE FROM USER_ROLE WHERE user_id = #{userId}")
    void deleteUserRoles(Long userId);

    @Delete("DELETE FROM USERS WHERE id = #{userId}")
    void deleteUserById(Long userId);

    @Select("SELECT p.id, p.name FROM ROLES r JOIN ROLE_PERMISSION rp ON rp.permission_id = p.id WHERE rp.role_id=#{id}")
    Role getPermissionByRoleId(Long id);
}
