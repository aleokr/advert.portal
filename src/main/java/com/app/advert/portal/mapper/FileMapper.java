package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.FileResponse;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT id, name, s3_key, content_type, resource_id, resource_type, file_type from FILES where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "s3Key", column = "s3_key"),
            @Result(property = "contentType", column = "content_type"),
            @Result(property = "resourceId", column = "resource_id"),
            @Result(property = "resourceType", column = "resource_type"),
            @Result(property = "fileType", column = "file_type")})
    File getFileById(Long id);

    @Select("SELECT id, name, s3_key, content_type, resource_id, resource_type, file_type from FILES where resource_id=#{resourceId} and resource_type=#{resourceType}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "s3Key", column = "s3_key"),
            @Result(property = "contentType", column = "content_type"),
            @Result(property = "resourceId", column = "resource_id"),
            @Result(property = "resourceType", column = "resource_type"),
            @Result(property = "fileType", column = "file_type")})
    List<File> getFilesByResourceId(Long resourceId, ResourceType resourceType);

    @Insert("INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) values (#{name},#{s3Key},#{contentType},#{resourceId},#{resourceType},#{fileType})")
    void saveFile(File file);

    @Update("UPDATE FILES SET name = #{name}, s3_key = #{s3Key}, content_type = #{contentType} where id = #{id}")
    void updateFile(File file);

    @Delete("DELETE FROM FILES where id=#{id}")
    void deleteFile(Long id);

    @Select("SELECT LAST_INSERT_ID()")
    Long lastAddFileId();


    @Select("SELECT name, null, file_type, s3_key, content_type from FILES where resource_id=#{resourceId} and resource_type=#{resourceType}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "fileName", column = "name"),
            @Result(property = "s3Key", column = "s3_key"),
            @Result(property = "contentType", column = "content_type"),
            @Result(property = "fileType", column = "file_type")})
    List<FileResponse> getFilesDataByResourceId(Long resourceId, ResourceType resourceType);
}
