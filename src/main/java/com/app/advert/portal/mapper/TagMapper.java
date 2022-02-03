package com.app.advert.portal.mapper;

import com.app.advert.portal.dto.TagResponse;
import com.app.advert.portal.enums.ResourceType;
import com.app.advert.portal.model.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TagMapper {

    @Insert("INSERT INTO TAGS (name) values (#{name})")
    void saveTag(String name);

    @Select("SELECT id, name from TAGS where name=#{name}")
    @Results(value = {
            @Result(property = "id", column = "id")})
    Tag getTagByName(String name);

    @Select("SELECT id, name from TAGS where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id")})
    Tag getTagById(Long id);

    @Insert("INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values (#{tagId}, #{resourceId}, #{type})")
    void saveResourceTag(Long resourceId, Long tagId, ResourceType type);

    @Select("SELECT EXISTS(SELECT * FROM RESOURCE_TAGS WHERE resource_id = #{resourceId} and tag_id = #{tagId} and resource_type = #{type})")
    boolean checkIfResourceTagExists(Long resourceId, Long tagId, ResourceType type);

    @Select("<script>" +
            "SELECT id, name from TAGS " +
            "ORDER BY name ASC " +
            "<if test = 'limit != null'> LIMIT #{limit}</if> " +
            "<if test = 'offset != null'> OFFSET #{offset}</if> " +
            "</script>")
    @Results(value = {
            @Result(property = "id", column = "id")})
    List<TagResponse> getTagsList(Integer limit, Integer offset);

    @Select("SELECT tag_id FROM RESOURCE_TAGS " +
            "WHERE resource_id = #{resourceId} and resource_type = #{type} ")
    List<Long> getTagIdsByResourceIdAndType(Long resourceId, ResourceType type);

    @Select("SELECT  t.id, t.name  FROM TAGS t " +
            "LEFT JOIN RESOURCE_TAGS r on r.tag_id = t.id " +
            "WHERE r.resource_id = #{resourceId} and r.resource_type = #{type} ")
    @Results(value = {
            @Result(property = "id", column = "id")})
    List<Tag> getTagsByResourceIdAndType(Long resourceId, ResourceType type);

    @Select("SELECT id, name from TAGS t " +
            "WHERE id NOT IN (SELECT tag_id  FROM RESOURCE_TAGS " +
            "WHERE resource_id = #{resourceId} and resource_type = #{type})" +
            "ORDER BY name ASC ")
    @Results(value = {
            @Result(property = "id", column = "id")})
    List<TagResponse> getAvailableTagsList(Long resourceId, ResourceType type);
}
