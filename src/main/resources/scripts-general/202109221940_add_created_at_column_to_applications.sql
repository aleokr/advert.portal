--liquibase formatted sql
--changeset aokrutny:220920212000
ALTER TABLE APPLICATIONS ADD COLUMN created_at TIMESTAMP;