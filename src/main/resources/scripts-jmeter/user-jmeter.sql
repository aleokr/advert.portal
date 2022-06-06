INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 1','Nazwisko', 'email_user_individual1@portal.com','pbrisson', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'pbrisson'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 2','Nazwisko', 'email_user_individual2@portal.com','kberisford1', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'kberisford1'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 3','Nazwisko', 'email_user_individual3@portal.com','tlavelle2', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'tlavelle2'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 4','Nazwisko', 'email_user_individual4@portal.com','fbrownlie3', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'fbrownlie3'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 5','Nazwisko', 'email_user_individual5@portal.com','lmulberry4', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'lmulberry4'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 6','Nazwisko', 'email_user_individual6@portal.com','krobrose5', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'krobrose5'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 7','Nazwisko', 'email_user_individual7@portal.com','rheliot6', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'rheliot6'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 8','Nazwisko', 'email_user_individual8@portal.com','pscardefield7', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'pscardefield7'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 9','Nazwisko', 'email_user_individual9@portal.com','bchafney8', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'bchafney8'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 10','Nazwisko', 'email_user_individual10@portal.com','hwarstall9', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hwarstall9'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 11','Nazwisko', 'email_user_individual11@portal.com','rjuliena', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'rjuliena'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 12','Nazwisko', 'email_user_individual12@portal.com','gzarfaib', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'gzarfaib'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 13','Nazwisko', 'email_user_individual13@portal.com','akeetsc', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'akeetsc'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 14','Nazwisko', 'email_user_individual14@portal.com','kmitrod', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'kmitrod'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 15','Nazwisko', 'email_user_individual15@portal.com','mcorrieae', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mcorrieae'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 16','Nazwisko', 'email_user_individual16@portal.com','jmaystonef', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jmaystonef'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 17','Nazwisko', 'email_user_individual17@portal.com','cbeardshallg', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cbeardshallg'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 18','Nazwisko', 'email_user_individual18@portal.com','mhesbrookh', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mhesbrookh'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 19','Nazwisko', 'email_user_individual19@portal.com','ctrimi', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ctrimi'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 20','Nazwisko', 'email_user_individual20@portal.com','pferonetj', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'pferonetj'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 21','Nazwisko', 'email_user_individual21@portal.com','bspaffordk', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'bspaffordk'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 22','Nazwisko', 'email_user_individual22@portal.com','hteresal', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hteresal'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 23','Nazwisko', 'email_user_individual23@portal.com','ddundonm', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ddundonm'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 24','Nazwisko', 'email_user_individual24@portal.com','bizhakovn', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'bizhakovn'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 25','Nazwisko', 'email_user_individual25@portal.com','lcriago', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'lcriago'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 26','Nazwisko', 'email_user_individual26@portal.com','jmoundp', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jmoundp'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 27','Nazwisko', 'email_user_individual27@portal.com','chasselbyq', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'chasselbyq'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 28','Nazwisko', 'email_user_individual28@portal.com','tgantzerr', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'tgantzerr'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 29','Nazwisko', 'email_user_individual29@portal.com','qbengocheas', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'qbengocheas'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 30','Nazwisko', 'email_user_individual30@portal.com','kbreedet', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'kbreedet'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 31','Nazwisko', 'email_user_individual31@portal.com','xhandoveru', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'xhandoveru'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 32','Nazwisko', 'email_user_individual32@portal.com','cworsfoldv', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cworsfoldv'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 33','Nazwisko', 'email_user_individual33@portal.com','vflobertw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'vflobertw'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 34','Nazwisko', 'email_user_individual34@portal.com','afalkusx', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'afalkusx'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 35','Nazwisko', 'email_user_individual35@portal.com','jgurdony', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jgurdony'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 36','Nazwisko', 'email_user_individual36@portal.com','lantoniewiczz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'lantoniewiczz'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 37','Nazwisko', 'email_user_individual37@portal.com','sarstingall10', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'sarstingall10'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 38','Nazwisko', 'email_user_individual38@portal.com','cmankor11', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cmankor11'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 39','Nazwisko', 'email_user_individual39@portal.com','ukirsche12', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ukirsche12'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 40','Nazwisko', 'email_user_individual40@portal.com','avelasquez13', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'avelasquez13'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 41','Nazwisko', 'email_user_individual41@portal.com','cfilippucci14', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cfilippucci14'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 42','Nazwisko', 'email_user_individual42@portal.com','vwoolfitt15', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'vwoolfitt15'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 43','Nazwisko', 'email_user_individual43@portal.com','gkidman16', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'gkidman16'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 44','Nazwisko', 'email_user_individual44@portal.com','mgraybeal17', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mgraybeal17'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 45','Nazwisko', 'email_user_individual45@portal.com','mkeely18', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mkeely18'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 46','Nazwisko', 'email_user_individual46@portal.com','gdawidsohn19', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'gdawidsohn19'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 47','Nazwisko', 'email_user_individual47@portal.com','plindsey1a', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'plindsey1a'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 48','Nazwisko', 'email_user_individual48@portal.com','nmcalroy1b', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'nmcalroy1b'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 49','Nazwisko', 'email_user_individual49@portal.com','bdiscombe1c', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'bdiscombe1c'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 50','Nazwisko', 'email_user_individual50@portal.com','ysikora1d', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ysikora1d'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 51','Nazwisko', 'email_user_individual51@portal.com','rfritchley1e', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'rfritchley1e'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 52','Nazwisko', 'email_user_individual52@portal.com','mdorot1f', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mdorot1f'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 53','Nazwisko', 'email_user_individual53@portal.com','gevamy1g', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'gevamy1g'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 54','Nazwisko', 'email_user_individual54@portal.com','emcdoual1h', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'emcdoual1h'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 55','Nazwisko', 'email_user_individual55@portal.com','hlissett1i', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hlissett1i'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 56','Nazwisko', 'email_user_individual56@portal.com','banning1j', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'banning1j'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 57','Nazwisko', 'email_user_individual57@portal.com','hsiebart1k', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hsiebart1k'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 58','Nazwisko', 'email_user_individual58@portal.com','jcoyish1l', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jcoyish1l'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 59','Nazwisko', 'email_user_individual59@portal.com','ihardison1m', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ihardison1m'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 60','Nazwisko', 'email_user_individual60@portal.com','rmattessen1n', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'rmattessen1n'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 61','Nazwisko', 'email_user_individual61@portal.com','fcuberley1o', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'fcuberley1o'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 62','Nazwisko', 'email_user_individual62@portal.com','atame1p', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'atame1p'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 63','Nazwisko', 'email_user_individual63@portal.com','zbirdwistle1q', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'zbirdwistle1q'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 64','Nazwisko', 'email_user_individual64@portal.com','kpele1r', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'kpele1r'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 65','Nazwisko', 'email_user_individual65@portal.com','mhedworth1s', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mhedworth1s'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 66','Nazwisko', 'email_user_individual66@portal.com','flatchmore1t', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'flatchmore1t'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 67','Nazwisko', 'email_user_individual67@portal.com','gillyes1u', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'gillyes1u'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 68','Nazwisko', 'email_user_individual68@portal.com','nculpen1v', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'nculpen1v'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 69','Nazwisko', 'email_user_individual69@portal.com','sberinger1w', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'sberinger1w'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 70','Nazwisko', 'email_user_individual70@portal.com','jmcgaugan1x', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jmcgaugan1x'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 71','Nazwisko', 'email_user_individual71@portal.com','sstathor1y', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'sstathor1y'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 72','Nazwisko', 'email_user_individual72@portal.com','slemmertz1z', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'slemmertz1z'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 73','Nazwisko', 'email_user_individual73@portal.com','ebrobak20', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ebrobak20'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 74','Nazwisko', 'email_user_individual74@portal.com','bdurtnell21', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'bdurtnell21'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 75','Nazwisko', 'email_user_individual75@portal.com','ebaudain22', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ebaudain22'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 76','Nazwisko', 'email_user_individual76@portal.com','tlightollers23', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'tlightollers23'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 77','Nazwisko', 'email_user_individual77@portal.com','hheggison24', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hheggison24'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 78','Nazwisko', 'email_user_individual78@portal.com','hsidebotham25', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hsidebotham25'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 79','Nazwisko', 'email_user_individual79@portal.com','agyppes26', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'agyppes26'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 80','Nazwisko', 'email_user_individual80@portal.com','hmacgauhy27', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'hmacgauhy27'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 81','Nazwisko', 'email_user_individual81@portal.com','nsybry28', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'nsybry28'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 82','Nazwisko', 'email_user_individual82@portal.com','fortells29', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'fortells29'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 83','Nazwisko', 'email_user_individual83@portal.com','nbrunesco2a', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'nbrunesco2a'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 84','Nazwisko', 'email_user_individual84@portal.com','mlangfat2b', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mlangfat2b'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 85','Nazwisko', 'email_user_individual85@portal.com','thallet2c', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'thallet2c'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 86','Nazwisko', 'email_user_individual86@portal.com','jchaffen2d', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jchaffen2d'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 87','Nazwisko', 'email_user_individual87@portal.com','ipestridge2e', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ipestridge2e'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 88','Nazwisko', 'email_user_individual88@portal.com','kmilbourn2f', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'kmilbourn2f'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 89','Nazwisko', 'email_user_individual89@portal.com','mvader2g', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'mvader2g'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 90','Nazwisko', 'email_user_individual90@portal.com','rloyd2h', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'rloyd2h'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 91','Nazwisko', 'email_user_individual91@portal.com','vnewson2i', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'vnewson2i'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 92','Nazwisko', 'email_user_individual92@portal.com','cstaziker2j', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cstaziker2j'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 93','Nazwisko', 'email_user_individual93@portal.com','ipetriello2k', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'ipetriello2k'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 94','Nazwisko', 'email_user_individual94@portal.com','sgilsthorpe2l', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'sgilsthorpe2l'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 95','Nazwisko', 'email_user_individual95@portal.com','bhussy2m', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'bhussy2m'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 96','Nazwisko', 'email_user_individual96@portal.com','slancastle2n', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'slancastle2n'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 97','Nazwisko', 'email_user_individual97@portal.com','gscudders2o', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'gscudders2o'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 98','Nazwisko', 'email_user_individual98@portal.com','nbardell2p', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'nbardell2p'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 99','Nazwisko', 'email_user_individual99@portal.com','tcortese2q', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'tcortese2q'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik idywidualny 100','Nazwisko', 'email_user_individual100@portal.com','cdight2r', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'cdight2r'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 1','Nazwisko', 'email_user_company1@portal.com','tallderidgedu', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 1') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'tallderidgedu'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 2','Nazwisko', 'email_user_company2@portal.com','cspencleydv', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 2') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cspencleydv'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 3','Nazwisko', 'email_user_company3@portal.com','ajoseydw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 3') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ajoseydw'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 4','Nazwisko', 'email_user_company4@portal.com','hkuschkedx', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 4') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'hkuschkedx'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 5','Nazwisko', 'email_user_company5@portal.com','lkeirdy', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 5') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'lkeirdy'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 6','Nazwisko', 'email_user_company6@portal.com','rstellindz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 6') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rstellindz'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 7','Nazwisko', 'email_user_company7@portal.com','clydiatee0', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 7') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'clydiatee0'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 8','Nazwisko', 'email_user_company8@portal.com','ghottone1', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 8') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ghottone1'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 9','Nazwisko', 'email_user_company9@portal.com','bwarnere2', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 9') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bwarnere2'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 10','Nazwisko', 'email_user_company10@portal.com','jvanderstraatene3', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 10') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jvanderstraatene3'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 11','Nazwisko', 'email_user_company11@portal.com','blangere4', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 11') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'blangere4'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 12','Nazwisko', 'email_user_company12@portal.com','serikssone5', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 12') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'serikssone5'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 13','Nazwisko', 'email_user_company13@portal.com','tarbere6', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 13') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'tarbere6'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 14','Nazwisko', 'email_user_company14@portal.com','cgronwe7', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 14') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cgronwe7'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 15','Nazwisko', 'email_user_company15@portal.com','cleecee8', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 15') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cleecee8'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 16','Nazwisko', 'email_user_company16@portal.com','acoathe9', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 16') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'acoathe9'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 17','Nazwisko', 'email_user_company17@portal.com','wludyeea', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 17') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'wludyeea'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 18','Nazwisko', 'email_user_company18@portal.com','rmasselineb', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 18') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rmasselineb'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 19','Nazwisko', 'email_user_company19@portal.com','saveryec', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 19') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'saveryec'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 20','Nazwisko', 'email_user_company20@portal.com','cpaolottoed', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 20') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cpaolottoed'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 21','Nazwisko', 'email_user_company21@portal.com','jlagoee', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 21') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jlagoee'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 22','Nazwisko', 'email_user_company22@portal.com','mshepardef', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 22') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'mshepardef'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 23','Nazwisko', 'email_user_company23@portal.com','bpritchardeg', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 23') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bpritchardeg'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 24','Nazwisko', 'email_user_company24@portal.com','scommoneh', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 24') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'scommoneh'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 25','Nazwisko', 'email_user_company25@portal.com','lclemendetei', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 25') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'lclemendetei'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 26','Nazwisko', 'email_user_company26@portal.com','cdevitaej', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 26') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cdevitaej'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 27','Nazwisko', 'email_user_company27@portal.com','ldobbisonek', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 27') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ldobbisonek'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 28','Nazwisko', 'email_user_company28@portal.com','mscreetonel', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 28') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'mscreetonel'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 29','Nazwisko', 'email_user_company29@portal.com','nacorsem', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 29') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'nacorsem'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 30','Nazwisko', 'email_user_company30@portal.com','otrenten', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 30') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'otrenten'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 31','Nazwisko', 'email_user_company31@portal.com','sbasleyeo', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 31') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'sbasleyeo'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 32','Nazwisko', 'email_user_company32@portal.com','fheballep', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 32') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'fheballep'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 33','Nazwisko', 'email_user_company33@portal.com','wjowerseq', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 33') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'wjowerseq'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 34','Nazwisko', 'email_user_company34@portal.com','rjaquemeer', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 34') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rjaquemeer'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 35','Nazwisko', 'email_user_company35@portal.com','cselvesteres', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 35') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cselvesteres'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 36','Nazwisko', 'email_user_company36@portal.com','eklimaset', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 36') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'eklimaset'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 37','Nazwisko', 'email_user_company37@portal.com','mwanklyneu', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 37') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'mwanklyneu'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 38','Nazwisko', 'email_user_company38@portal.com','gtalmadgeev', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 38') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gtalmadgeev'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 39','Nazwisko', 'email_user_company39@portal.com','lscraceew', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 39') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'lscraceew'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 40','Nazwisko', 'email_user_company40@portal.com','gbinnellex', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 40') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gbinnellex'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 41','Nazwisko', 'email_user_company41@portal.com','brounsefulley', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 41') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'brounsefulley'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 42','Nazwisko', 'email_user_company42@portal.com','blancleyez', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 42') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'blancleyez'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 43','Nazwisko', 'email_user_company43@portal.com','wcowdryf0', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 43') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'wcowdryf0'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 44','Nazwisko', 'email_user_company44@portal.com','souchterlonyf1', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 44') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'souchterlonyf1'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 45','Nazwisko', 'email_user_company45@portal.com','bbroadbentf2', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 45') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bbroadbentf2'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 46','Nazwisko', 'email_user_company46@portal.com','amacadamf3', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 46') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'amacadamf3'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 47','Nazwisko', 'email_user_company47@portal.com','bpretorf4', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 47') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bpretorf4'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 48','Nazwisko', 'email_user_company48@portal.com','tcranstounf5', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 48') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'tcranstounf5'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 49','Nazwisko', 'email_user_company49@portal.com','dgartenfeldf6', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 49') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'dgartenfeldf6'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 50','Nazwisko', 'email_user_company50@portal.com','btuttlef7', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 50') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'btuttlef7'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 51','Nazwisko', 'email_user_company51@portal.com','npettifordf8', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 51') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'npettifordf8'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 52','Nazwisko', 'email_user_company52@portal.com','rbasindalef9', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 52') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rbasindalef9'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 53','Nazwisko', 'email_user_company53@portal.com','eworsleyfa', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 53') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'eworsleyfa'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 54','Nazwisko', 'email_user_company54@portal.com','bkinchinfb', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 54') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bkinchinfb'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 55','Nazwisko', 'email_user_company55@portal.com','rnairyfc', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 55') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rnairyfc'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 56','Nazwisko', 'email_user_company56@portal.com','byearbyfd', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 56') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'byearbyfd'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 57','Nazwisko', 'email_user_company57@portal.com','cjohannfe', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 57') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cjohannfe'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 58','Nazwisko', 'email_user_company58@portal.com','belfleetff', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 58') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'belfleetff'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 59','Nazwisko', 'email_user_company59@portal.com','bburnandfg', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 59') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bburnandfg'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 60','Nazwisko', 'email_user_company60@portal.com','cspyvyefh', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 60') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cspyvyefh'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 61','Nazwisko', 'email_user_company61@portal.com','ptaigfi', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 61') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ptaigfi'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 62','Nazwisko', 'email_user_company62@portal.com','milemfj', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 62') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'milemfj'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 63','Nazwisko', 'email_user_company63@portal.com','dbudnkfk', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 63') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'dbudnkfk'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 64','Nazwisko', 'email_user_company64@portal.com','jboxefl', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 64') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jboxefl'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 65','Nazwisko', 'email_user_company65@portal.com','dchippinfm', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 65') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'dchippinfm'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 66','Nazwisko', 'email_user_company66@portal.com','sbroggettifn', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 66') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'sbroggettifn'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 67','Nazwisko', 'email_user_company67@portal.com','sknealefo', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 67') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'sknealefo'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 68','Nazwisko', 'email_user_company68@portal.com','dtessymanfp', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 68') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'dtessymanfp'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 69','Nazwisko', 'email_user_company69@portal.com','gkmieciakfq', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 69') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gkmieciakfq'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 70','Nazwisko', 'email_user_company70@portal.com','cchomiczfr', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 70') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'cchomiczfr'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 71','Nazwisko', 'email_user_company71@portal.com','gelliottfs', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 71') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gelliottfs'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 72','Nazwisko', 'email_user_company72@portal.com','pcalvenft', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 72') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'pcalvenft'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 73','Nazwisko', 'email_user_company73@portal.com','hgauvainfu', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 73') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'hgauvainfu'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 74','Nazwisko', 'email_user_company74@portal.com','gbattiefv', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 74') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gbattiefv'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 75','Nazwisko', 'email_user_company75@portal.com','ahorryfw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 75') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ahorryfw'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 76','Nazwisko', 'email_user_company76@portal.com','mpawlowiczfx', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 76') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'mpawlowiczfx'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 77','Nazwisko', 'email_user_company77@portal.com','llukasenfy', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 77') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'llukasenfy'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 78','Nazwisko', 'email_user_company78@portal.com','ddesforgesfz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 78') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ddesforgesfz'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 79','Nazwisko', 'email_user_company79@portal.com','nclaybourneg0', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 79') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'nclaybourneg0'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 80','Nazwisko', 'email_user_company80@portal.com','lstetlyeg1', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 80') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'lstetlyeg1'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 81','Nazwisko', 'email_user_company81@portal.com','bokellg2', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 81') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'bokellg2'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 82','Nazwisko', 'email_user_company82@portal.com','nhaskewg3', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 82') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'nhaskewg3'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 83','Nazwisko', 'email_user_company83@portal.com','wdemcheng4', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 83') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'wdemcheng4'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 84','Nazwisko', 'email_user_company84@portal.com','mburrusg5', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 84') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'mburrusg5'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 85','Nazwisko', 'email_user_company85@portal.com','vscreatong6', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 85') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'vscreatong6'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 86','Nazwisko', 'email_user_company86@portal.com','atakosg7', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 86') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'atakosg7'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 87','Nazwisko', 'email_user_company87@portal.com','kmcewang8', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 87') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'kmcewang8'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 88','Nazwisko', 'email_user_company88@portal.com','rvonwelldung9', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 88') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rvonwelldung9'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 89','Nazwisko', 'email_user_company89@portal.com','pferrarottiga', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 89') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'pferrarottiga'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 90','Nazwisko', 'email_user_company90@portal.com','apurdiegb', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 90') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'apurdiegb'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 91','Nazwisko', 'email_user_company91@portal.com','ltidygc', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 91') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'ltidygc'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 92','Nazwisko', 'email_user_company92@portal.com','anegalgd', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 92') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'anegalgd'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 93','Nazwisko', 'email_user_company93@portal.com','echrichtonge', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 93') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'echrichtonge'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 94','Nazwisko', 'email_user_company94@portal.com','btadmangf', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 94') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'btadmangf'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 95','Nazwisko', 'email_user_company95@portal.com','gdederickgg', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 95') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gdederickgg'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 96','Nazwisko', 'email_user_company96@portal.com','jdougillgh', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 96') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jdougillgh'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 97','Nazwisko', 'email_user_company97@portal.com','mashbeygi', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 97') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'mashbeygi'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 98','Nazwisko', 'email_user_company98@portal.com','leasungj', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 98') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'leasungj'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 99','Nazwisko', 'email_user_company99@portal.com','jdornangk', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 99') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jdornangk'));

INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Użytkownik firmowy 100','Nazwisko', 'email_user_company100@portal.com','jmottengl', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 100') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jmottengl'));

