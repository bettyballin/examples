
CREATE TABLE user_groups (
    group_name VARCHAR NOT NULL,
    user_name VARCHAR NOT NULL,
    PRIMARY KEY (group_name, user_name)
);

