--liquibase formatted sql
--changeset aokrutny:090820211737
CREATE TABLE COMPANIES (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR (2000)
);
