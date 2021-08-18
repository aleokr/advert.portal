package com.app.advert.portal.mapper;

import com.app.advert.portal.model.Company;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompanyMapper {

    @Select("SELECT id, name, description FROM COMPANIES WHERE id = #{id}")
    Company getById(Long id);

    @Select("SELECT id, name, description FROM COMPANIES WHERE name = #{name}")
    Company getCompanyByName(String name);

    @Insert("INSERT INTO COMPANIES(name, description) values (#{name},#{description})")
    void saveCompany(Company company);

    @Update("UPDATE COMPANIES SET name = #{name}, description = #{description} where id = #{id}")
    void updateCompany(Company company);

    @Delete("DELETE FROM COMPANIES WHERE id = #{companyId}")
    void deleteCompanyById(Long companyId);
}
