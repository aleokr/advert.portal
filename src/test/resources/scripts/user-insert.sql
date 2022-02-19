--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company','Test company description');

--DELETE USER WITH FILES
--FILE USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('File', 'User','file@test.com','test_file','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');
--FILES
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File User Image','assa213314sda', 'image/png', (SELECT id FROM USERS WHERE login = 'test_file') , 'USER', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File User  Attachment','assa213314sda', 'application/pdf', (SELECT id FROM USERS WHERE login = 'test_file') , 'USER', 'ATTACHMENT');

-- ADDITIONAL USER DATA TEST
-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_ADMIN');

-- COMPANY USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'User','company@test.com','test_company','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_USER');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_Individual','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');

--COMPANY ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company 1', 'Advert Company Short 1',
        'Advert Company Long 1', (SELECT id FROM USERS WHERE login = 'test_admin'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());

INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company 2', 'Advert Company Short 2',
        'Advert Company Long 2', (SELECT id FROM USERS WHERE login = 'test_company'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'PHYSICS'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());

INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company 3', 'Advert Company Short 3',
        'Advert Company Long 3', (SELECT id FROM USERS WHERE login = 'test_company'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'OTHER'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());

--USER ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert User 1', 'Advert User Short 1',
        'Advert User Long 1', (SELECT id FROM USERS WHERE login = 'test_Individual'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'), now());

INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert User 2', 'Advert Company User 2',
        'Advert User Long 2', (SELECT id FROM USERS WHERE login = 'test_Individual'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'PHYSICS'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'), now());

--COMPANY APPLICATIONS
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert User 1'),
         (SELECT id FROM USERS WHERE login = 'test_company'), (SELECT id FROM COMPANIES WHERE name = 'Test company'), now());

INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert User 2'),
         (SELECT id FROM USERS WHERE login = 'test_admin'), (SELECT id FROM COMPANIES WHERE name = 'Test company'), now());

--USER APPLICATIONS
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert Company 2'),
         (SELECT id FROM USERS WHERE login = 'test_Individual'), null, now());

--COMPANY FILES
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('Company Image','assa213314sda', 'image/png', (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('Company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY', 'ATTACHMENT');
