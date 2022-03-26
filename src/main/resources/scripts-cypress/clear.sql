
DELETE FROM USER_ROLES WHERE user_id = (SELECT id FROM USERS WHERE login = 'jasek');
DELETE FROM USERS WHERE login = 'jasek';

DELETE FROM USER_ROLES WHERE user_id = (SELECT id FROM USERS WHERE login = 'anial');
DELETE FROM USERS WHERE login = 'anial';

DELETE FROM USER_ROLES WHERE user_id = (SELECT id FROM USERS WHERE login = 'karolkraj');
DELETE FROM USERS WHERE login = 'karolkraj';

DELETE FROM USER_ROLES WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress');
DELETE FROM USER_ROLES WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress2');
DELETE FROM USER_ROLES WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress3');

DELETE FROM APPLICATIONS WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress');
DELETE FROM APPLICATIONS WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress2');
DELETE FROM APPLICATIONS WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress3');

DELETE FROM ADVERTS WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress');
DELETE FROM ADVERTS WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress2');
DELETE FROM ADVERTS WHERE user_id = (SELECT id FROM USERS WHERE login = 'cypress3');

DELETE FROM USERS WHERE login = 'cypress';
DELETE FROM USERS WHERE login = 'cypress2';
DELETE FROM USERS WHERE login = 'cypress3';


DELETE FROM COMPANIES WHERE name = 'Cypress company';
DELETE FROM COMPANIES WHERE name = 'cypress company test';