--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company','Test company description');
INSERT INTO COMPANIES (name, description) VALUES ('Test company2','Test company description');

-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_ADMIN');
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin2','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company2') , 'COMPANY_ADMIN');

-- COMPANY USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'User','company@test.com','test_company','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company') , 'COMPANY_USER');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual2','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual3','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');

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

INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company2', 'Advert Company2 Short',
        'Advert Company Long', (SELECT id FROM USERS WHERE login = 'test_admin2'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert Company2 2', 'Advert Company2 Short2',
        'Advert Company Long2', (SELECT id FROM USERS WHERE login = 'test_admin2'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'OTHER'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'), now());

--USER ADVERTS
INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert User 1', 'Advert User Short 1',
        'Advert User Long 1', (SELECT id FROM USERS WHERE login = 'test_individual'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'), now());

INSERT INTO ADVERTS (title, short_description, long_description, user_id, category_id, type_id, created_at) VALUES ('Advert User 2', 'Advert Company User 2',
        'Advert User Long 2', (SELECT id FROM USERS WHERE login = 'test_individual'), (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'PHYSICS'),
         (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'), now());

--COMPANY APPLICATIONS
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert User 1'),
         (SELECT id FROM USERS WHERE login = 'test_company'), (SELECT id FROM COMPANIES WHERE name = 'Test company'), now());

INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert User 2'),
         (SELECT id FROM USERS WHERE login = 'test_admin'), (SELECT id FROM COMPANIES WHERE name = 'Test company'), now());

--USER APPLICATIONS
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert Company 2'),
         (SELECT id FROM USERS WHERE login = 'test_individual'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Advert Company2'),
         (SELECT id FROM USERS WHERE login = 'test_individual2'), null, now());
