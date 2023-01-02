--liquibase formatted sql

--changeset Rassulkhair:create-file-directories-table

CREATE TABLE file_directories
(
    id            BIGSERIAL PRIMARY KEY NOT NULL,
    name          VARCHAR(255)          NOT NULL,
    user_id       BIGINT                NOT NULL REFERENCES users (id),
    parent_id     BIGINT REFERENCES file_directories (id),
    date_created  TIMESTAMP             NOT NULL DEFAULT LOCALTIMESTAMP,
    date_modified TIMESTAMP,
    external_id   UUID                  NOT NULL UNIQUE
);
CREATE INDEX ON file_directories (user_id);
CREATE INDEX ON file_directories (parent_id);

--changeset Rassulkhair:create-files-table

CREATE TABLE files
(
    id            BIGSERIAL PRIMARY KEY NOT NULL,
    name          VARCHAR(255)          NOT NULL,
    directory_id  BIGINT                NOT NULL REFERENCES file_directories (id),
    size          INTEGER               NOT NULL,
    date_created  TIMESTAMP             NOT NULL DEFAULT LOCALTIMESTAMP,
    date_modified TIMESTAMP,
    type          VARCHAR(255)          NOT NULL,
    data          BIGINT                NOT NULL
);
CREATE INDEX ON files (directory_id);




