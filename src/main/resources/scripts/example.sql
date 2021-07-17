--liquibase formatted sql
--changeset aokrutny:9
CREATE TABLE POST (
                      id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                      title VARCHAR(400) NOT NULL,
                      content VARCHAR(2000) NULL,
                      created timestamp
);
CREATE TABLE COMMENT (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         post_id BIGINT NOT NULL,
                         content VARCHAR(2000) NULL,
                         created timestamp
);
create table user(
                     id BIGINT AUTO_INCREMENT primary key,
                     name VARCHAR(40) not null,
                     password VARCHAR(10) not null
);
    insert into user values(1, 'Tom', '123456');
insert into user values(2, 'Jack', 'abcdef');