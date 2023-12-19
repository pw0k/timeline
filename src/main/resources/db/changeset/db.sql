--liquibase formatted sql

--changeset timeline:1
create table tm_user
(
    id   bigserial primary key,
    name text
);

--changeset timeline:2
create table tm_group
(
    id bigserial primary key,
    title text NOT NULL,
    description text NOT NULL
);

--changeset timeline:3
create table post
(
    id bigserial primary key,
    title text NOT NULL,
    description text NOT NULL,
    user_id BIGINT REFERENCES tm_user(id)
);

--changeset timeline:4
create table user_follow
(
    id bigserial primary key,
    user_id BIGINT REFERENCES tm_user(id),
    group_id BIGINT REFERENCES tm_group(id)
);


