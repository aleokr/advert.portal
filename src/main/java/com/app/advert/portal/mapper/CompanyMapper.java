package com.app.advert.portal.mapper;

import com.app.advert.portal.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CompanyMapper {

    @Select("SELECT * FROM COMPANIES WHERE id = #{id}")
    Company getById(Integer id);
}
