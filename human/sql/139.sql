CREATE OR REPLACE FUNCTION f_meta(p_code IN VARCHAR2)
  RETURN SYS_REFCURSOR
AS
  l_cursor SYS_REFCURSOR;
BEGIN
  IF p_code = 'rk' THEN
    OPEN l_cursor FOR
      SELECT 'information tech' AS industry, 'technology' AS sector FROM dual
      UNION ALL
      SELECT 'financials' AS industry, 'financial' AS sector FROM dual;
  ELSIF p_code = 'pa' THEN
    OPEN l_cursor FOR
      SELECT 'information tech' AS industry, 'technology' AS sector, 'cyber security' AS subindustry FROM dual
      UNION ALL
      SELECT 'financials' AS industry, 'financial' AS sector, 'banks' AS subindustry FROM dual;
  END IF;
  RETURN l_cursor;
END f_meta;

SELECT f_meta('rk') FROM dual;

SELECT f_meta('pa') FROM dual;