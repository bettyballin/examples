WITH data ( value ) AS (
  SELECT 'abc%def' UNION ALL
  SELECT 'abcdef'
)
SELECT * FROM data WHERE value LIKE '%\%%' ESCAPE '\';