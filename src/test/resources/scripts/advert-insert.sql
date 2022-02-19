--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company','Test company description');

-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin_ad','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_ADMIN');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');

--COMPANY ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company 1', 'Advert Company Short 1',
        'Advert Company Long 1', (SELECT id FROM USERS WHERE login = 'test_admin_ad'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());

--USER ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert User 1', 'Advert User Short 1',
        'Advert User Long 1', (SELECT id FROM USERS WHERE login = 'test_individual'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'), now());

INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert User 2', 'Advert User Short 2',
        'Advert User Long 2', (SELECT id FROM USERS WHERE login = 'test_individual'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'PHYSICS'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'), now());

--FILES
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Image','assa213314sda', 'image/png', (SELECT id FROM ADVERTS WHERE title = 'Advert User 1') , 'ADVERT', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM ADVERTS WHERE title = 'Advert User 1') , 'ADVERT', 'ATTACHMENT');


INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Image','assa213314sda', 'image/png', (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY', 'ATTACHMENT');
