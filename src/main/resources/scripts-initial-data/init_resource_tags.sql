--RESOURCE_TAGS
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'java'), (SELECT id FROM USERS WHERE login = 'markra'), 'USER');
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'html'), (SELECT id FROM USERS WHERE login = 'dobwys'), 'USER');
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'lab'), (SELECT id FROM USERS WHERE login = 'brusaw'), 'USER');


INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'maths'), (SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 1'), 'ADVERT');
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'java'), (SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 5'), 'ADVERT');
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'art'), (SELECT id FROM ADVERTS WHERE title = 'Ogłoszenie testowe 23'), 'ADVERT');


INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'biology'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 3'), 'COMPANY');
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'physics'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 11'), 'COMPANY');
INSERT INTO RESOURCE_TAGS (tag_id, resource_id, resource_type) values ((SELECT id FROM TAGS WHERE name = 'it'), (SELECT id FROM COMPANIES WHERE name = 'Firma testowa 7'), 'COMPANY');
