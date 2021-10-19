package com.app.advert.portal.mapper;

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

    @Insert("INSERT INTO RESOURCE_TAG (tag_id, resource_id) values (#{tagId}, #{resourceId})")
    void saveResourceTag(Long resourceId, Long tagId);

    @Select("<script>" +
            "SELECT id, name from TAGS " +
            "ORDER BY name ASC " +
            "<if test = 'limit != null'> LIMIT #{limit}</if> " +
            "<if test = 'offset != null'> OFFSET #{offset}</if> " +
            "</script>")
    @Results(value = {
            @Result(property = "id", column = "id")})
    List<Tag> getTagsList(Integer limit, Integer offset);
}
