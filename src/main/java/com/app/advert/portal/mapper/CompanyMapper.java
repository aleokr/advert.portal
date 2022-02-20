package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.CompanyListRequest;
import com.app.advert.portal.dto.CompanyResponse;
import com.app.advert.portal.dto.UserResponse;
import com.app.advert.portal.model.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Select("SELECT id, name, description, null, null, null, null, null, null from COMPANIES where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "members", javaType = List.class, column = "id", many = @Many(select = "getCompanyUsers"))
    })
    CompanyResponse getById(Long id);

    @Select("SELECT id, name, description FROM COMPANIES WHERE name = #{name}")
    Company getCompanyByName(String name);

    @Insert("INSERT INTO COMPANIES(name, description) values (#{name},#{description})")
    void saveCompany(Company company);

    @Update("UPDATE COMPANIES SET name = #{name}, description = #{description} where id = #{id}")
    void updateCompany(Company company);

    @Delete("DELETE FROM COMPANIES WHERE id = #{companyId}")
    void deleteCompanyById(Long companyId);

    @Select("<script>" +
            "SELECT id, name, null, null, null, null, null, null FROM COMPANIES WHERE 1 = 1 " +
            "<if test = 'name != null'> and name LIKE CONCAT('%', #{name}, '%') </if> " +
            "<if test = 'limit != null'> LIMIT #{limit} </if> " +
            "<if test = 'offset != null'> OFFSET #{offset}</if> " +
            "</script>")
    List<CompanyResponse> getCompaniesList(CompanyListRequest companyListRequest);

    @Select("SELECT id, name, description, null, null, null, null, null, null, null from COMPANIES where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "members", javaType = List.class, column = "id", many = @Many(select = "getCompanyUsers"))
    })
    CompanyResponse getLoggedUserCompany(Long id);

    @Select("SELECT id, name, surname, email, login from USERS where company_id=#{id} and active = true")
    @Results(value = {
            @Result(property = "id", column = "id")
    })
    List<UserResponse> getCompanyUsers(Long id);

    @Select("SELECT id, name, surname, email, login from USERS where company_id=#{id} and active = false")
    List<UserResponse> getRequestToJoin(Long id);
}
