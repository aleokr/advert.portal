--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company1','Test company description');
INSERT INTO COMPANIES (name, description) VALUES ('Test company2','Test company description');

-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company1') , 'COMPANY_ADMIN');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual_file','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');

--COMPANY ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company 1', 'Advert Company Short 1',
        'Advert Company Long 1', (SELECT id FROM USERS WHERE login = 'test_admin'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());

--FILES
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Image','assa213314sda', 'image/png', (SELECT id FROM ADVERTS WHERE title = 'Advert Company 1') , 'ADVERT', 'IMAGE');
INSERT INTO FILES(name, s3_key, content_type, resource_id, resource_type, file_type) VALUES
        ('File company Attachment','assa213314sda', 'application/pdf', (SELECT id FROM ADVERTS WHERE title = 'Advert Company 1') , 'ADVERT', 'ATTACHMENT');