INSERT INTO COMPANIES (name, description) VALUES ('Cypress company', 'Cypress Test Company');
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Cypress', 'Test', 'cypress.test@portal.pl', 'cypress', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Cypress company'),true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cypress'));


INSERT INTO TAGS (name) VALUES ('test');
INSERT INTO TAGS (name) VALUES ('cypress');

DELETE FROM ADVERTS WHERE title = 'Cypress test advert';

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Cypress2', 'Test', 'cypress2.test@portal.pl', 'cypress2', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cypress2'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Cypress3', 'Test', 'cypress3.test@portal.pl', 'cypress3', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cypress3'));

INSERT INTO ADVERTS (title, short_description, long_description, archived, user_id, type_id, category_id, created_at) VALUES ('Cypress individual 1', 'Short description', 'Long description', 0,
                                                                                                                              (SELECT id FROM USERS WHERE login = 'cypress3'), (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'),
                                                                                                                              (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'CHEMISTRY'), now());
INSERT INTO ADVERTS (title, short_description, long_description, archived, user_id, type_id, category_id, created_at) VALUES ('Cypress individual 2', 'Short description', 'Long description', 0,
                                                                                                                              (SELECT id FROM USERS WHERE login = 'cypress3'), (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'),
                                                                                                                              (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'COMPUTER_SCIENCE'), now());
INSERT INTO ADVERTS (title, short_description, long_description, archived, user_id, type_id, category_id, created_at) VALUES ('Cypress individual 3', 'Short description', 'Long description', 0,
                                                                                                                              (SELECT id FROM USERS WHERE login = 'cypress3'), (SELECT id FROM ADVERT_TYPES WHERE name = 'INDIVIDUAL'),
                                                                                                                              (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'PHYSICS'), now());

INSERT INTO ADVERTS (title, short_description, long_description, archived, user_id, type_id, category_id, created_at) VALUES ('Cypress company 1', 'Short description', 'Long description', 0,
                                                                                                                              (SELECT id FROM USERS WHERE login = 'cypress'), (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'),
                                                                                                                              (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'OTHER'), now());

INSERT INTO ADVERTS (title, short_description, long_description, archived, user_id, type_id, category_id, created_at) VALUES ('Cypress company 2', 'Short description', 'Long description', 0,
                                                                                                                              (SELECT id FROM USERS WHERE login = 'cypress'), (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'),
                                                                                                                              (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'BIOLOGY'), now());

INSERT INTO ADVERTS (title, short_description, long_description, archived, user_id, type_id, category_id, created_at) VALUES ('Cypress company 3', 'Short description', 'Long description', 0,
                                                                                                                              (SELECT id FROM USERS WHERE login = 'cypress'), (SELECT id FROM ADVERT_TYPES WHERE name = 'COMPANY'),
                                                                                                                              (SELECT id FROM ADVERT_CATEGORIES WHERE name = 'ARCHITECTURE'), now());