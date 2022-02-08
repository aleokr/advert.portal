--liquibase formatted sql
--changeset aokrutny:090820211659

ALTER TABLE USERS ADD COLUMN company_id INTEGER;
