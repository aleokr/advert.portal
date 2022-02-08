--liquibase formatted sql
--changeset aokrutny:210920211350
ALTER TABLE USERS ADD COLUMN user_type enum ('COMPANY_USER', 'INDIVIDUAL_USER', 'COMPANY_ADMIN');