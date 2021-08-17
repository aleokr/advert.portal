package com.app.advert.portal.mapper;

import com.app.advert.portal.model.Company;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompanyMapper {

    @Select("SELECT id, name, description FROM COMPANIES WHERE id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description")})
    Company getById(Long id);

    @Select("SELECT id, name, description FROM COMPANIES WHERE name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description")})
    Company getCompanyByName(String name);

    @Insert("INSERT INTO COMPANIES(name, description) values (#{name},#{description})")
    void saveCompany(Company company);

    @Update("UPDATE COMPANIES SET name = #{company.name}, description = #{company.description} where id = #{companyId}")
    void updateCompany(Company company, Long companyId);

    @Delete("DELETE FROM COMPANIES WHERE id = #{companyId}")
    void deleteCompanyById(Long companyId);
}
