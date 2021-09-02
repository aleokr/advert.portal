package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.ApplicationListRequest;
import com.app.advert.portal.dto.ApplicationResponse;
import com.app.advert.portal.model.Application;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    @Select("<script>" +
            "SELECT a.advert_id  as advertId, ad.title as advertTitle, a.user_id as userId, CONCAT(u.name, ' ', u.surname) as userName, " +
            "null as companyId,  null as companyName FROM APPLICATIONS a " +
            "LEFT JOIN USERS u ON u.id = a.user_id " +
            "LEFT JOIN ADVERTS ad ON ad.id = a.advert_id " +
            "WHERE 1 = 1 " +
            "<if test = 'companyId != null'> and a.company_id = #{companyId} </if> " +
            "<if test = 'userId != null'> and a.user_id = #{userId} </if> " +
            "<if test = 'request.limit != null'> LIMIT #{request.limit}</if> " +
            "<if test = 'request.offset != null'> OFFSET #{request.offset}</if> " +
            "</script>")
    List<ApplicationResponse> getUserApplications(ApplicationListRequest request, Long userId, Long companyId);

    @Select("<script>" +
            "SELECT a.advert_id  as advertId, ad.title as advertTitle, " +
            "<choose>" +
            "  <when test='companyId != null'> " +
            "   a.user_id as userId, CONCAT(u.name, ' ', u.surname) as userName, null as companyId, null as companyName " +
            " </when>" +
            "  <otherwise> null as userId, null as userName, a.company_id as companyId, c.name as companyName </otherwise>" +
            "</choose>" +
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
            "<if test = 'request.limit != null'> LIMIT #{request.limit}</if> " +
            "<if test = 'request.offset != null'> OFFSET #{request.offset}</if> " +
            "</script>")
    List<ApplicationResponse> getResponsesToUserAdverts(ApplicationListRequest request, Long userId, Long companyId);

    @Insert("INSERT INTO APPLICATIONS(advert_id, user_id, company_id) values (#{advertId}, #{userId}, #{companyId})")
    void saveAdvert(Application application);

    @Select("<script>" +
            "SELECT EXISTS(SELECT 1 FROM APPLICATIONS WHERE advert_id = #{advertId}" +
            "<if test = 'userId != null'> and user_id = #{userId} </if> " +
            "<if test = 'companyId != null'> and company_id = #{companyId} </if> " +
            " LIMIT 1) " +
            "</script>")
    Boolean checkApplicationExists(Long advertId, Long userId, Long companyId);
}
