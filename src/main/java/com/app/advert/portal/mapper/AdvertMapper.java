package com.app.advert.portal.mapper;

import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdvertMapper {
    @Select("SELECT * FROM ADVERTS")
    List<Advert> getAll();
}
