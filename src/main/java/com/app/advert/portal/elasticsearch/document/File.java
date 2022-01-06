package com.app.advert.portal.elasticsearch.document;

import com.app.advert.portal.elasticsearch.helper.Indices;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Data
@Document(indexName = Indices.FILES_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class File {

    @Id
    @Field(type = FieldType.Keyword)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword)
    private Long resourceId;

    @Field(type = FieldType.Text)
    private String resourceType;

    @Field(type = FieldType.Text)
    private String advertType;

    @Field(type = FieldType.Text)
    private String data;

    @Field(type = FieldType.Object)
    private Attachment attachment;
}
