--USERS
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Jolanta', 'Wójcik', 'jolanta.wojcik@portal.pl', 'jolwoj', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 1') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jolwoj'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Regina', 'Kucharska', 'regina.kucharska@portal.pl', 'regkuch', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 2') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'regkuch'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Marta', 'Wiśniewska', 'marta.wisniewska@portal.pl', 'marwis', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 3') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'marwis'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Jadwiga', 'Piotrowska', 'jadwiga.piotrowska@portal.pl', 'jadpio', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 4') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'jadpio'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Bernadetta', 'Kwiatkowska', 'bernadetta.kwiatkowska@portal.pl', 'berkwi', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 5') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'berkwi'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Ola', 'Sikora', 'ola.sikora@portal.pl', 'olasik', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 6') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'olasik'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Katarzyna', 'Kubiak', 'katarzyna.kubiak@portal.pl', 'katkub', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 7') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'katkub'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Felicja', 'Ostrowska', 'felicja.ostrowska@portal.pl', 'felost', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 8') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'felost'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Eryk', 'Kaźmierczak', 'eryk.kazmierczak@portal.pl', 'erykaz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 9') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'erykaz'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Mateusz', 'Przybylski', 'mateusz.przybylski@portal.pl', 'matprz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 10') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'matprz'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Maksymilian', 'Kucharski', 'maksymilian.kucharski@portal.pl', 'makkuc', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 11') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'makkuc'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Andrzej', 'Michalak', 'andrzej.michalak@portal.pl', 'andmic', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 12') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'andmic'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Natan', 'Marciniak', 'natan.marciniak@portal.pl', 'natmar', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 13') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'natmar'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Rafał', 'Maciejewski', 'rafal.maciejewski@portal.pl', 'rafmac', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 14') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'rafmac'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Gabriel', 'Zawadzki', 'gabriel.zawadzki@portal.pl', 'gabzaw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 15') ,true, 'COMPANY_ADMIN');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_ADMIN'), (SELECT id FROM USERS WHERE login = 'gabzaw'));


INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Remigiusz', 'Jaworski', 'remigiusz.jaworski@portal.pl', 'remjaw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 1') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'remjaw'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Arkadiusz', 'Sobczak', 'arkadiusz.sobczak@portal.pl', 'arksob', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 2') ,false, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'arksob'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Oktawian', 'Kozłowski', 'oktawian.kozlowski@portal.pl', 'oktkoz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 3') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'oktkoz'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Henryk', 'Brzeziński', 'henryk.brzezinski@portal.pl', 'henbrz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 4') ,false, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'henbrz'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Klaudiusz', 'Maciejewski', 'klaudiusz.maciejewski@portal.pl', 'klamac', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 5') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'klamac'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Magda', 'Kamińska', 'magda.kaminska@portal.pl', 'magkam', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 6') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'magkam'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Kaja', 'Szczepańska', 'kaja.szczepanska@portal.pl', 'kajszc', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 7') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'kajszc'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Oksana', 'Sawicka', 'oksana.sawicka@portal.pl', 'okssaw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 8') ,false, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'okssaw'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Jolanta', 'Kucharska', 'jolanta.kucharska@portal.pl', 'jolkuc', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 9') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'jolkuc'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Monika', 'Zalewska', 'monika.zalewska@portal.pl', 'monzal', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 10') ,true, 'COMPANY_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'COMPANY_USER'), (SELECT id FROM USERS WHERE login = 'monzal'));



INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Natasza', 'Górska', 'natasza.gorska@portal.pl', 'natgor', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'natgor'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Agata', 'Lis', 'agata.lis@portal.pl', 'agalis', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'agalis'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Marysia', 'Sikorska', 'marysia.sikorska@portal.pl', 'marsik', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'marsik'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Lidia', 'Baranowska', 'lidia.baranowska@portal.pl', 'lidbar', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'lidbar'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Krystyna', 'Michalak', 'krystyna.michalak@portal.pl', 'krymic', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'krymic'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Konstancja', 'Jasińska', 'konstancja.jasinska@portal.pl', 'konjas', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'konjas'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Elwira', 'Zawadzka', 'elwira.zawadzka@portal.pl', 'elwzaw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'elwzaw'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Julita', 'Kalinowska', 'julita.kalinowska@portal.pl', 'julkal', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'julkal'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Marta', 'Krawczyk', 'marta.krawczyk@portal.pl', 'markra', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'markra'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Beata', 'Sokołowska', 'beata.sokolowska@portal.pl', 'beasok', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'beasok'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Juliusz', 'Pietrzak', 'juliusz.pietrzak@portal.pl', 'julpie', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'julpie'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Józef', 'Jakubowski', 'jozef.jakubowski@portal.pl', 'jozjak', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'jozjak'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Krzysztof', 'Zalewski', 'krzysztof.zalewski@portal.pl', 'krzzal', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'krzzal'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Dobromił', 'Wysocki', 'dobromil.wysocki@portal.pl', 'dobwys', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'dobwys'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Mariusz', 'Jakubowski', 'mariusz.jakubowski@portal.pl', 'marjak', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'marjak'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Kamil', 'Brzeziński', 'kamil.brzezinski@portal.pl', 'kambrze', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'kambrze'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Dorian', 'Mazurek', 'dorian.mazurek@portal.pl', 'dormaz', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'dormaz'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Bruno', 'Sawicki', 'bruno.sawicki@portal.pl', 'brusaw', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'brusaw'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Heronim', 'Kwiatkowski', 'heronim.kwiatkowski@portal.pl', 'herkwi', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'herkwi'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Bartosz', 'Kalinowski', 'bartosz.kalinowski@portal.pl', 'barkal', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'barkal'));
INSERT INTO USERS (name, surname, email, login, password, created_at, company_id, active, user_type) VALUES ('Emanuel', 'Walczak', 'emanuel.walczak@portal.pl', 'emawal', '$2a$10$xxYjJ26yEl.ftnFnWTezH.PSPAPv5bihPOi7I.JzKCPRbI5KbY0dy', now(),
                                                                                                             null ,true, 'INDIVIDUAL_USER');
INSERT INTO USER_ROLES (role_id, user_id) VALUES ((SELECT id FROM ROLES WHERE name = 'INDIVIDUAL_USER'), (SELECT id FROM USERS WHERE login = 'emawal'));
