package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.AdvertListRequest;
import com.app.advert.portal.dto.AdvertResponse;
import com.app.advert.portal.enums.AdvertCategory;
import com.app.advert.portal.model.Advert;
import com.app.advert.portal.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdvertMapper {
    @Select(
            "<script>" +
                    "SELECT a.id as id, a.title as title, a.short_description as shortDescription, null as longDescription, a.archived as archived, " +
                    "a.user_id as ownerId, c.name as advertCategory, t.name as advertType, DATE_FORMAT(a.created_at, '%Y-%m-%d') as createdAt,  " +
                    "<choose>" +
                    "  <when test = 'request.type != null and request.type.name() == \"INDIVIDUAL\" '> concat(u.name, ' ', u.surname) as addedBy </when>" +
                    "  <otherwise> com.name as addedBy </otherwise>" +
                    "</choose>" +
                    "FROM ADVERTS a " +
                    "LEFT JOIN USERS u ON u.id = a.user_id " +
                    "LEFT JOIN ADVERT_CATEGORY c on c.id = a.category_id " +
                    "LEFT JOIN ADVERT_TYPE t on t.id = a.type_id " +
                    "<if test = 'request.type == null or request.type.name() == \"COMPANY\" '> LEFT JOIN COMPANIES com ON com.id = u.company_id </if> " +
                    "WHERE 1 = 1 " +
                    "<if test = 'request.type != null'> and t.name = #{request.type} and a.archived = false </if> " +
                    "<if test = 'request.id != null'> and a.id = #{request.id}</if> " +
                    "<if test = 'request.companyId != null'> and u.company_id = #{request.companyId} </if> " +
                    "<if test = 'request.userId != null'> and a.user_id = #{request.userId} </if> " +
                    "<if test = 'advertIds != null'> and a.id IN" +
                    "    <foreach item='item' index='index' collection='advertIds'" +
                    "       open='(' separator=',' close=')'>" +
                    "       #{item}" +
                    "    </foreach> " +
                    "</if> " +
                    "ORDER BY a.created_at DESC" +
                    "<if test = 'request.limit != null'> LIMIT #{request.limit}</if> " +
                    "<if test = 'request.offset != null'> OFFSET #{request.offset}</if> " +
                    "</script>")
    List<AdvertResponse> getAdvertList(AdvertListRequest request, @Param("advertIds") List<Long> advertIds);

    @Select("SELECT a.id, a.title, a.short_description, a.long_description, a.user_id, null as advertCategory, t.name as advertType" +
            "FROM ADVERTS a" +
            "LEFT JOIN ADVERT_TYPE t on t.id = a.type_id +" +
            "WHERE id = #{id}")
    @Results(value = {
            @Result(property = "shortDescription", column = "short_description"),
            @Result(property = "longDescription", column = "long_description"),
            @Result(property = "userId", column = "user_id")})
    Advert getById(Long id);

    @Insert("INSERT INTO ADVERTS(title, short_description, long_description, user_id, category_id, type_id, created_at) " +
            "values (#{title}, #{shortDescription}, #{longDescription}, #{userId}," +
            "(SELECT id FROM ADVERT_CATEGORY WHERE name = #{category})," +
            "(SELECT id FROM ADVERT_TYPE WHERE name = #{type}), now()) ")
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
            @Result(property = "companyId", column = "company_id")})
    User getUserByAdvertId(Long advertId);

    @Select("SELECT name from ADVERT_CATEGORY ORDER BY name ASC")
    List<AdvertCategory> getAdvertCategories();

    @Select("<script>" +
            "SELECT  count(*) " +
            "FROM ADVERTS a " +
            "LEFT JOIN USERS u ON u.id = a.user_id " +
            "LEFT JOIN ADVERT_CATEGORY c on c.id = a.category_id " +
            "LEFT JOIN ADVERT_TYPE t on t.id = a.type_id " +
            "WHERE 1 = 1 " +
            "<if test = 'type != null'> and t.name = #{type} and a.archived = false </if> " +
            "<if test = 'id != null'> and a.id = #{id}</if> " +
            "<if test = 'companyId != null'> and u.company_id = #{companyId} </if> " +
            "<if test = 'userId != null'> and a.user_id = #{userId} </if> " +
            "</script>")
    Integer getAdvertsCountByUser(AdvertListRequest request);

    @Select("<script>" +
            "SELECT a.id as id, a.title as title, a.short_description as shortDescription, a.long_description as longDescription, a.archived,  " +
            "CASE " +
            "   WHEN t.name LIKE 'COMPANY' THEN com.id  " +
            "   ELSE a.user_id " +
            "END as ownerId, " +
            "c.name as advertCategory, t.name as advertType, DATE_FORMAT(a.created_at, '%Y-%m-%d') as createdAt,  " +
            "CASE " +
            "   WHEN t.name LIKE 'COMPANY' THEN com.name  " +
            "   ELSE  concat(u.name, ' ', u.surname) " +
            "END as addedBy " +
            "FROM ADVERTS a " +
            "LEFT JOIN USERS u ON u.id = a.user_id " +
            "LEFT JOIN ADVERT_CATEGORY c on c.id = a.category_id " +
            "LEFT JOIN ADVERT_TYPE t on t.id = a.type_id " +
            "LEFT JOIN COMPANIES com ON com.id = u.company_id " +
            "WHERE a.id = #{id} " +
            "</script>")
    AdvertResponse getAdvertInfoById(Long id);

    @Select(
            "<script>" +
                    "SELECT a.id as id, a.title as title, a.short_description as shortDescription, null as longDescription, a.archived,  " +
                    "a.user_id as ownerId, c.name as advertCategory, t.name as advertType, DATE_FORMAT(a.created_at, '%Y-%m-%d') as createdAt,  " +
                    "<choose>" +
                    "  <when test = 'request.type != null and request.type.name() == \"INDIVIDUAL\" '> concat(u.name, ' ', u.surname) as addedBy, </when>" +
                    "  <otherwise> com.name as addedBy, </otherwise>" +
                    "</choose>" +
                    "<choose>" +
                    "  <when test = 'tagIds == null || tagIds.isEmpty()'> 0 as count </when>" +
                    "  <otherwise> " +
                    "    (select count(*) from RESOURCE_TAG where tag_id in" +
                    "    <foreach item='item' index='index' collection='tagIds'" +
                    "       open='(' separator=',' close=')'>" +
                    "       #{item}" +
                    "    </foreach>" +
                    "    and resource_id = a.id and resource_type = \"ADVERT\") as count " +
                    "  </otherwise>" +
                    "</choose>" +
                    "FROM ADVERTS a " +
                    "LEFT JOIN USERS u ON u.id = a.user_id " +
                    "LEFT JOIN ADVERT_CATEGORY c on c.id = a.category_id " +
                    "LEFT JOIN ADVERT_TYPE t on t.id = a.type_id " +
                    "<if test = 'request.type == null or request.type.name() == \"COMPANY\" '> LEFT JOIN COMPANIES com ON com.id = u.company_id </if> " +
                    "WHERE a.archived = false  " +
                    "<if test = 'request.type != null'> and t.name = #{request.type}</if> " +
                    "<if test = 'request.id != null'> and a.id = #{request.id}</if> " +
                    "<if test = 'request.companyId != null'> and u.company_id = #{request.companyId} </if> " +
                    "<if test = 'request.userId != null'> and a.user_id = #{request.userId} </if> " +
                    "ORDER BY count DESC, createdAt DESC" +
                    "<if test = 'request.limit != null'> LIMIT #{request.limit}</if> " +
                    "<if test = 'request.offset != null'> OFFSET #{request.offset}</if> " +
                    "</script>")
    List<AdvertResponse> getAdvertListByTags(AdvertListRequest request, @Param("tagIds") List<Long> tagIds);
}
