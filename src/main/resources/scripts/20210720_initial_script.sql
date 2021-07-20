--liquibase formatted sql
--changeset aokrutny:200720212030

CREATE TABLE USERS (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    surname VARCHAR(100),
    email VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_at timestamp
);

CREATE TABLE ADVERTS (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    short_description VARCHAR(300) NOT NULL,
    long_description VARCHAR(600)
);

CREATE TABLE FILES (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    path VARCHAR(200) NOT NULL
)
