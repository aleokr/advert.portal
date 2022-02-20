--liquibase formatted sql
--changeset aokrutny:220820211827
ALTER TABLE USERS ADD COLUMN active BOOLEAN default false;
