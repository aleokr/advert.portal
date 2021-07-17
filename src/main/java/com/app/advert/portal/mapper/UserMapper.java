package com.app.advert.portal.mapper;

import com.app.advert.portal.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = 1")
    User getPersonById();
}
