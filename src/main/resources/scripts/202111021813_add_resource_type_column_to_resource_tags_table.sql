--liquibase formatted sql
--changeset aokrutny:021120211814
ALTER TABLE RESOURCE_TAG ADD COLUMN resource_type ENUM ('USER', 'ADVERT', 'COMPANY');