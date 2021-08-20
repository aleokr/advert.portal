package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdvertMapper {
    @Select("<script>" +
            "SELECT a.id, a.title, a.short_description, a.long_description FROM ADVERTS a " +
            "<if test = 'companyId != null'> LEFT JOIN USERS u ON u.id = a.user_id </if> " +
            "WHERE 1 = 1 " +
            "<if test = 'id != null'> and a.id = #{id}</if> " +
            "<if test = 'companyId != null'> and u.company_id = #{companyId} </if> " +
            "<if test = 'userId != null'> and a.user_id = #{userId} </if> " +
            "<if test = 'limit != null'> LIMIT #{limit}</if> " +
            "<if test = 'offset != null'> OFFSET #{offset}</if> " +
            "</script>")
    @Results(value = {
            @Result(property = "shortDescription", column = "short_description"),
            @Result(property = "longDescription", column = "long_description")})
    List<Advert> getAdvertList(AdvertListRequest request);

    @Select("SELECT id, title, short_description, long_description, user_id FROM ADVERTS WHERE id = #{id}")
    @Results(value = {
            @Result(property = "shortDescription", column = "short_description"),
            @Result(property = "longDescription", column = "long_description"),
            @Result(property = "userId", column = "user_id")})
    Advert getById(Long id);

    @Insert("INSERT INTO ADVERTS(title, short_description, long_description, user_id) values (#{title}, #{shortDescription}, #{longDescription}, #{userId})")
    void saveAdvert(Advert advert);

    @Update("UPDATE ADVERTS SET title = #{title}, short_description = #{shortDescription}, long_description = #{longDescription} where id = #{id}")
    void updateAdvert(Advert advert);

    @Delete("DELETE FROM ADVERTS WHERE id = #{advertId}")
    void deleteAdvertById(Long advertId);

    @Update("UPDATE ADVERTS SET archived = true where id = #{advertId}")
    void archivedAdvert(Long advertId);

    @Select("SELECT LAST_INSERT_ID()")
    Long lastAddAdvertId();

    @Select("SELECT u.id, u.name, u.surname, u.email, u.login, u.company_id from USERS u LEFT JOIN ADVERTS a on a.user_id = u.id " +
            "where a.id=#{advertId}")
    @Results(value = {
            @Result(property = "companyId", column = "company_id")
    })
    User getUserByAdvertId(Long advertId);
}
