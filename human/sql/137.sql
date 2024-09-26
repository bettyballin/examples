CREATE TABLE metadata (
  C_ VARCHAR(2),
  SHORT_DESC VARCHAR(20)
);

INSERT INTO metadata (C_, SHORT_DESC) VALUES
  ('rk', 'sector'),
  ('rk', 'industry'),
  ('pa', 'industry'),
  ('pa', 'sector'),
  ('pa', 'subindustry');

CREATE TABLE master_data (
  ID VARCHAR(10),
  SECTOR VARCHAR(20),
  INDUSTRY VARCHAR(30),
  SUBINDUSTRY VARCHAR(30)
);

INSERT INTO master_data (ID, SECTOR, INDUSTRY, SUBINDUSTRY) VALUES
  ('5949', 'technology', 'information tech', 'cyber security'),
  ('g046', 'financial', 'financials', 'banks');

SELECT * FROM metadata;
SELECT * FROM master_data;