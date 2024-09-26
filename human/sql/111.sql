CREATE TABLE data(
   id integer PRIMARY KEY,
   val text,
   acl text[] NOT NULL
);

INSERT INTO data VALUES (1, 'one',   ARRAY['laurenz', 'advpg']);
INSERT INTO data VALUES (2, 'two',   ARRAY['advpg']);
INSERT INTO data VALUES (3, 'three', ARRAY['laurenz']);