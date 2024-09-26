CREATE TABLE group_members (
  member_id INT,
  user_name VARCHAR(255),
  group_name VARCHAR(255)
);

INSERT INTO group_members (member_id, user_name, group_name) VALUES
    (1, 'abc', 'permanent'),
    (2, 'xyz', 'permanent'),
    (3, 'Jason', 'abc'),
    (4, 'Roy', 'abc'),
    (5, 'Jane', 'xyz');

SELECT * FROM group_members;