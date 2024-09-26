CREATE TABLE users (
  id INT,
  name VARCHAR(255)
);

INSERT INTO users (id, name) VALUES
  (1, 'O\'Reilly'),
  (2, 'OReilly'),
  (3, 'Other');

SELECT * FROM users WHERE name LIKE 'O\\%Reilly' ESCAPE '\\';