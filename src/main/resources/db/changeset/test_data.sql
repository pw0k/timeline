--liquibase formatted sql

--changeset test_data:1
INSERT INTO tm_user (name)
VALUES ('Rick Sanchez');
INSERT INTO tm_user (name)
VALUES ('Morty Smith');
INSERT INTO tm_user (name)
VALUES ('Summer Smith');
INSERT INTO tm_user (name)
VALUES ('Beth Smith');
INSERT INTO tm_user (name)
VALUES ('Jerry Smith');
INSERT INTO tm_user (name)
VALUES ('Birdperson');
INSERT INTO tm_user (name)
VALUES ('Squanchy');
INSERT INTO tm_user (name)
VALUES ('Mr.Meeseeks');
INSERT INTO tm_user (name)
VALUES ('Snuffles');
INSERT INTO tm_user (name)
VALUES ('Unity');

--changeset test_data:2
INSERT INTO tm_group (groupname, description)
VALUES ('Meeseeks', 'I''m Mr. Meeseeks, look at me!');
INSERT INTO tm_group (groupname, description)
VALUES ('Pickle Team', 'Pickle Pickle');

--changeset test_data:3
INSERT INTO post (user_id, title, description)
VALUES ((SELECT id FROM tm_user WHERE name = 'Jerry Smith'),
        'I’m not looking for judgement, just a yes or no',
        'Can you assimilate a giraffe?');
INSERT INTO post (group_id, title, description)
VALUES ((SELECT id FROM tm_group WHERE groupname = 'Meeseeks'),
        'I''m Mr. Meeseeks',
        'Look at me!');
INSERT INTO post (user_id, title, description)
VALUES ((SELECT id FROM tm_user WHERE name = 'Rick Sanchez'),
        'Wubba Lubba',
        'Dub Dub');

--changeset test_data:4
INSERT INTO follow (follower_id, followee_user_id, followee_group_id)
VALUES ((SELECT id FROM tm_user WHERE name = 'Morty Smith'),
        (SELECT id FROM tm_user WHERE name = 'Rick Sanchez'),
        NULL);
INSERT INTO follow (follower_id, followee_user_id, followee_group_id)
VALUES ((SELECT id FROM tm_user WHERE name = 'Jerry Smith'),
        (SELECT id FROM tm_group WHERE groupname = 'Meeseeks'),
        NULL);
INSERT INTO follow (follower_id, followee_user_id, followee_group_id)
VALUES ((SELECT id FROM tm_user WHERE name = 'Morty Smith'),
        NULL,
        (SELECT id FROM tm_group WHERE groupname = 'Meeseeks'));

--changeset test_data:5
INSERT INTO post (user_id, title, description)
VALUES ((SELECT id FROM tm_user WHERE name = 'Rick Sanchez'),
        'Get Schwifty',
        'Schwifty Schwifty Schwifty');
