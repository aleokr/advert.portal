--liquibase formatted sql
--changeset aokrutny:100820211851
ALTER TABLE USERS ADD CONSTRAINT f_company_id FOREIGN KEY (company_id) REFERENCES COMPANIES(id);