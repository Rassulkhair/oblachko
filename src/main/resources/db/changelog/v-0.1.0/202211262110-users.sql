--liquibase formatted sql

--changeset Rassulkhair:create-users-table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(64) NOT NULL);

CREATE UNIQUE INDEX ON users (username);

--changeset Rassulkhair:create-user-roles-table

CREATE TABLE roles(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    user_id BIGINT NOT NULL REFERENCES users (id),
    role VARCHAR(255) NOT NULL
);
CREATE INDEX ON roles (user_id);



