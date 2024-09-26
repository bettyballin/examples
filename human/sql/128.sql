DECLARE
  vsql VARCHAR2(100);
  vresult NUMBER;
  vname VARCHAR2(30) := 'SCOTT';  -- replace with desired schema name
BEGIN
  vsql := 'SELECT COUNT(1) FROM all_objects WHERE owner = :1';
  EXECUTE IMMEDIATE vsql INTO vresult USING vname;
  DBMS_OUTPUT.PUT_LINE(vresult);
END;