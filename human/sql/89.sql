CREATE TABLE people (
  personid INT,
  name VARCHAR(255)
);

CREATE TABLE users (
  personid INT,
  username VARCHAR(255)
);

INSERT INTO people (personid, name)
VALUES
  (1, 'John Doe'),
  (2, 'Jane Doe'),
  (3, 'Bob Smith');

INSERT INTO users (personid, username)
VALUES
  (1, 'johndoe'),
  (2, 'janedoe');

SELECT p.*
FROM people p
WHERE NOT EXISTS (SELECT 1 FROM users u WHERE p.personid = u.personid);