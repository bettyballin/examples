CREATE TABLE login_attempts (
  id INT PRIMARY KEY,
  lastaccess TIMESTAMP
);

INSERT INTO login_attempts (id, lastaccess) 
VALUES 
(1, NOW() - INTERVAL 10 MINUTE),
(2, NOW() - INTERVAL 3 MINUTE);

SELECT * FROM login_attempts;

DELETE FROM login_attempts WHERE lastaccess < NOW() - INTERVAL 5 MINUTE;

SELECT * FROM login_attempts;