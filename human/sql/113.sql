CREATE TABLE data (
  id INTEGER,
  val VARCHAR(10)
);

INSERT INTO data (id, val) VALUES
  (1, 'one'),
  (3, 'three');

SELECT id, val FROM data;