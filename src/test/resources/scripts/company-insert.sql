-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_ADMIN');


--COMPANIES
INSERT INTO COMPANIES (name, description) VALUES ('Test company 1','Test company description 1');
INSERT INTO COMPANIES (name, description) VALUES ('Test company 2','Test company description 2');
INSERT INTO COMPANIES (name, description) VALUES ('Test company 3','Test company description 3');
INSERT INTO COMPANIES (name, description) VALUES ('Test company 4','Test company description 4');


--COMPANY WITH FILES
INSERT INTO COMPANIES (name, description) VALUES ('File company','File company description');

INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Image','assa213314sda', 'image/png', (SELECT id FROM COMPANIES WHERE name = 'File company') , 'COMPANY', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM COMPANIES WHERE name = 'File company') , 'COMPANY', 'ATTACHMENT');


--LOGGED  USER COMPANY DATA
INSERT INTO COMPANIES (name, description) VALUES ('Logged user data','Test logged user data description');
--USERS
-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin2','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Logged user data') , 'COMPANY_ADMIN');

-- COMPANY USERS
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'User','company@test.com','test_company2','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Logged user data') , 'COMPANY_USER');
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'User','company@test.com','test_company_not_active','absh123!%$',now(), false, (SELECT id FROM COMPANIES WHERE name = 'Logged user data') , 'COMPANY_USER');

--COMPANY FILES
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('Company Image','assa213314sda', 'image/png', (SELECT id FROM COMPANIES WHERE name = 'Logged user data') , 'COMPANY', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('Company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM COMPANIES WHERE name = 'Logged user data') , 'COMPANY', 'ATTACHMENT');

--COMPANY WITH FILES 2
INSERT INTO COMPANIES (name, description) VALUES ('File company 2','File company description');

INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Image','assa213314sda', 'image/png', (SELECT id FROM COMPANIES WHERE name = 'File company 2') , 'COMPANY', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM COMPANIES WHERE name = 'File company 2') , 'COMPANY', 'ATTACHMENT');