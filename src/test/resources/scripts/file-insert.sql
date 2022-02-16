--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company','Test company description');

-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_ADMIN');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');

--COMPANY ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company 1', 'Advert Company Short 1',
        'Advert Company Long 1', (SELECT id FROM USERS WHERE login = 'test_admin'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());