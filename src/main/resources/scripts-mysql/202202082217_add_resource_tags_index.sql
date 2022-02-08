--liquibase formatted sql
--changeset aokrutny:080220222218
ALTER TABLE RESOURCE_TAGS ADD INDEX (resource_id);
ALTER TABLE RESOURCE_TAGS ADD INDEX (tag_id);