--liquibase formatted sql
--changeset aokrutny:170820211216
CREATE TABLE APPLICATIONS (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    advert_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    company_id INTEGER,
    FOREIGN KEY (advert_id) REFERENCES ADVERTS(id),
    FOREIGN KEY (user_id) REFERENCES USERS(id),
    FOREIGN KEY (company_id) REFERENCES COMPANIES(id)
);