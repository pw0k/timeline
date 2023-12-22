--liquibase formatted sql

--changeset timeline:1
CREATE TABLE tm_user
(
    id   BIGSERIAL primary key,
    name TEXT NOT NULL
);

--changeset timeline:2
CREATE TABLE tm_group
(
    id          BIGSERIAL primary key,
    groupname   TEXT NOT NULL,
    description TEXT NOT NULL
);

--changeset timeline:3

CREATE TABLE post
(
    id          BIGSERIAL primary key,
    title       TEXT NOT NULL,
    description TEXT NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id     BIGINT REFERENCES tm_user (id),
    group_id    BIGINT REFERENCES tm_group (id),
    CONSTRAINT post_check_user_or_group_not_null
        CHECK ((user_id IS NULL AND group_id IS NOT NULL) OR
               (user_id IS NOT NULL AND group_id IS NULL))
);

--changeset timeline:4
CREATE TABLE follow
(
    follower_id       BIGINT NOT NULL REFERENCES tm_user (id),
    followee_user_id  BIGINT REFERENCES tm_user (id),
    followee_group_id BIGINT REFERENCES tm_group (id),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (follower_id, followee_user_id, followee_group_id),
    CONSTRAINT follow_check_followee_user_id_or_followee_group_id_not_null
        CHECK ((followee_user_id IS NULL AND followee_group_id IS NOT NULL) OR
               (followee_user_id IS NOT NULL AND followee_group_id IS NULL))
);


