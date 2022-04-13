--APPLICATIONS
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 1'),
                                                                              (SELECT id FROM USERS WHERE login = 'jolwoj'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 1'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 2'),
                                                                              (SELECT id FROM USERS WHERE login = 'regkuch'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 2'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 3'),
                                                                              (SELECT id FROM USERS WHERE login = 'marwis'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 3'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 4'),
                                                                              (SELECT id FROM USERS WHERE login = 'jadpio'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 4'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 5'),
                                                                              (SELECT id FROM USERS WHERE login = 'berkwi'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 5'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 6'),
                                                                              (SELECT id FROM USERS WHERE login = 'olasik'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 6'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 7'),
                                                                              (SELECT id FROM USERS WHERE login = 'katkub'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 7'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 8'),
                                                                              (SELECT id FROM USERS WHERE login = 'felost'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 8'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 9'),
                                                                              (SELECT id FROM USERS WHERE login = 'erykaz'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 9'), now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 10'),
                                                                              (SELECT id FROM USERS WHERE login = 'matprz'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 10'), now());

INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 31'),
                                                                              (SELECT id FROM USERS WHERE login = 'emawal'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 32'),
                                                                              (SELECT id FROM USERS WHERE login = 'barkal'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 33'),
                                                                              (SELECT id FROM USERS WHERE login = 'herkwi'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 34'),
                                                                              (SELECT id FROM USERS WHERE login = 'brusaw'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 35'),
                                                                              (SELECT id FROM USERS WHERE login = 'dormaz'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 36'),
                                                                              (SELECT id FROM USERS WHERE login = 'kambrze'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 37'),
                                                                              (SELECT id FROM USERS WHERE login = 'marjak'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 38'),
                                                                              (SELECT id FROM USERS WHERE login = 'dobwys'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 39'),
                                                                              (SELECT id FROM USERS WHERE login = 'krzzal'), null, now());
INSERT INTO APPLICATIONS (advert_id, user_id, company_id, created_at) VALUES ((SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 40'),
                                                                              (SELECT id FROM USERS WHERE login = 'jozjak'), null, now());
