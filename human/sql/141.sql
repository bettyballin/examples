SET ESCAPE '\';
WITH data ( value ) AS (
  SELECT 'abc%def' FROM DUAL UNION ALL
  SELECT 'abcdef'  FROM DUAL
)
SELECT * FROM data WHERE value LIKE '%\%%' ESCAPE '\';