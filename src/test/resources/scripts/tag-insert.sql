--TAGS
INSERT INTO TAGS (name) values ('test1');
INSERT INTO TAGS (name) values ('test2');
INSERT INTO TAGS (name) values ('test3');

-- INDIVIDUAL TAG USER WITH NO TAGS
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','tag_Individual','absh123!%$', now(), true, null , 'INDIVIDUAL_USER');
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','tag_Individual2','absh123!%$', now(), true, null , 'INDIVIDUAL_USER');

--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company','Test company description');
INSERT INTO COMPANIES (name, description) VALUES ('Tag company','Test company description');
INSERT INTO COMPANIES (name, description) VALUES ('Tag company2','Test company description');

-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_ADMIN');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_Individual','absh123!%$', now(), true, null , 'INDIVIDUAL_USER');

-- COMPANY USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_company_tag','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Tag company') , 'COMPANY_USER');
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_company_tag2','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Tag company2') , 'COMPANY_USER');


