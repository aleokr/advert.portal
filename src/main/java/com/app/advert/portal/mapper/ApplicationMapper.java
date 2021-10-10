package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationResponse;
import com.app.advert.portal.model.Application;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    @Select("<script>" +
            "SELECT a.advert_id  as advertId, ad.title as advertTitle, ad.short_description as advertShortDescription, a.user_id as userId, CONCAT(u.name, ' ', u.surname) as userName, " +
            "null as companyId, null as companyName, " +
            "ac.name as advertCategory, a.created_at as createdAt " +
            "FROM APPLICATIONS a " +
            "LEFT JOIN USERS u ON u.id = a.user_id " +
            "LEFT JOIN ADVERTS ad ON ad.id = a.advert_id " +
            "LEFT JOIN ADVERT_CATEGORY ac on ac.id = ad.category_id " +
            "WHERE 1 = 1 " +
            "<if test = 'companyId != null'> and a.company_id = #{companyId} </if> " +
            "<if test = 'userId != null'> and a.user_id = #{userId} </if> " +
            "<if test = 'request.limit != null'> LIMIT #{request.limit}</if> " +
            "<if test = 'request.offset != null'> OFFSET #{request.offset}</if> " +
            "</script>")
    List<ApplicationResponse> getUserApplications(ApplicationListRequest request, Long userId, Long companyId);

    @Select("<script>" +
            "SELECT a.advert_id  as advertId, ad.title as advertTitle, ad.short_description as advertShortDescription, " +
            "<choose>" +
            "  <when test='companyId != null'> " +
            "   a.user_id as userId, CONCAT(u.name, ' ', u.surname) as addedBy, null as companyId, " +
            " </when>" +
            "  <otherwise> null as userId, c.name as addedBy, c.id as companyId, </otherwise>" +
            "</choose> " +
            "ac.name as advertCategory, a.created_at as createdAt " +
            "FROM APPLICATIONS a " +
            "LEFT JOIN ADVERTS ad ON ad.id = a.advert_id " +
            "LEFT JOIN ADVERT_CATEGORY ac on ac.id = ad.category_id " +
            "<choose>" +
            "  <when test='companyId != null'> " +
            "   LEFT JOIN USERS u on u.id = a.user_id" +
            "   LEFT JOIN USERS ur on ur.id = ad.user_id " +
            " </when>" +
            "  <otherwise> " +
            "   LEFT JOIN COMPANIES c ON c.id = a.company_id  " +
            "  </otherwise>" +
            "</choose>" +
            "WHERE 1 = 1 " +
            "<if test = 'userId != null'> and ad.user_id = #{userId} </if> " +
            "<if test = 'companyId != null'> and ur.company_id = #{companyId} </if> " +
            "<if test = 'request.limit != null'> LIMIT #{request.limit}</if> " +
            "<if test = 'request.offset != null'> OFFSET #{request.offset}</if> " +
            "</script>")
    List<ApplicationResponse> getResponsesToUserAdverts(ApplicationListRequest request, Long userId, Long companyId);

    @Insert("INSERT INTO APPLICATIONS(advert_id, user_id, company_id, created_at) values (#{advertId}, #{userId}, #{companyId}, now())")
    void saveAdvert(Application application);

    @Select("<script>" +
            "SELECT EXISTS(SELECT 1 FROM APPLICATIONS WHERE advert_id = #{advertId}" +
            "<if test = 'userId != null'> and user_id = #{userId} </if> " +
            "<if test = 'companyId != null'> and company_id = #{companyId} </if> " +
            " LIMIT 1) " +
            "</script>")
    Boolean checkApplicationExists(Long advertId, Long userId, Long companyId);

    @Select("<script>" +
            "SELECT  count(*) " +
            "FROM APPLICATIONS a " +
            "LEFT JOIN USERS u ON u.id = a.user_id " +
            "WHERE 1 = 1 " +
            "<if test = 'companyId != null'> and a.company_id = #{companyId} </if> " +
            "<if test = 'userId != null'> and a.user_id = #{userId} </if> " +
            "</script>")
    Integer getResponsesCountByUser(Long companyId, Long userId);

    @Select("<script>" +
            "SELECT  count(*) " +
            "FROM APPLICATIONS a " +
            "LEFT JOIN ADVERTS ad ON ad.id = a.advert_id " +
            "<choose>" +
            "  <when test='companyId != null'> " +
            "   LEFT JOIN USERS u on u.id = a.user_id" +
            "   LEFT JOIN USERS ur on ur.id = ad.user_id " +
            " </when>" +
            "  <otherwise> " +
            "   LEFT JOIN COMPANIES c ON c.id = a.company_id  " +
            "  </otherwise>" +
            "</choose>" +
            "WHERE 1 = 1 " +
            "<if test = 'userId != null'> and ad.user_id = #{userId} </if> " +
            "<if test = 'companyId != null'> and ur.company_id = #{companyId} </if> " +
            "</script>")
    Integer getApplicationsCountByUser(Long companyId, Long userId);
}
