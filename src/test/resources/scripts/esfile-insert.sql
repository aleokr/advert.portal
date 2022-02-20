--COMPANY
INSERT INTO COMPANIES (name, description) VALUES ('Test company_file','Test company description');

-- ADMIN USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Company', 'Admin','admin@test.com','test_admin_file','absh123!%$',now(), true, (SELECT id FROM COMPANIES WHERE name = 'Test company_file') , 'COMPANY_ADMIN');

-- INDIVIDUAL USER
INSERT INTO USERS (name, surname, email, login, password, created_at, active, company_id, user_type)
        VALUES ('Individual', 'User','individual@test.com','test_individual_file_es','absh123!%$',now(), true, null , 'INDIVIDUAL_USER');
