--liquibase formatted sql
--changeset aokrutny:120920211421
CREATE TABLE ADVERT_TYPE (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE ADVERT_CATEGORY (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);


INSERT INTO ADVERT_TYPE (name) VALUES ('COMPANY'), ('INDIVIDUAL');

INSERT INTO ADVERT_CATEGORY (name) VALUES ('ADMINISTRATION'),('ARCHITECTURE'), ('BIOLOGY'), ('CHEMISTRY'), ('COMPUTER_SCIENCE'),
                                            ('ELECTRONICS'), ('JOURNALISM'), ('MANAGEMENT'), ('MATHEMATICS'), ('OTHER'), ('PHYSICS'), ('TRANSPORT');