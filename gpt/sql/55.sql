
CREATE VIEW api.mytable WITH (security_barrier) AS 
SELECT * FROM private.mytable WHERE true;

