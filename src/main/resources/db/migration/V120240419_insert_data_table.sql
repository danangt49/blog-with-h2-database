-- Insert roles
INSERT INTO roles (id, name) VALUES (1, 'USER');

-- Insert users
INSERT INTO users (id, name, username, email, password, created_at, updated_at)
VALUES (1, 'User', 'user', 'user@gmail.com', '$2a$12$O2mq/PmduyhbZhFR2m65R.7rHn1I8LeBoMsoyzcMGS.Wz1Btvroh.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert user_roles
INSERT INTO user_roles (role_id, user_id) VALUES (1, 1);
