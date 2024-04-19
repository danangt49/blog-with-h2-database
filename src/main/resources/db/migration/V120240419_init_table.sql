CREATE SEQUENCE blogs_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE roles_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE blogs
(
    id         BIGINT NOT NULL,
    title      VARCHAR(255),
    body       VARCHAR(255),
    author     VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT pk_blogs PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

CREATE TABLE users
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    username   VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_roles FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_users FOREIGN KEY (user_id) REFERENCES users (id);