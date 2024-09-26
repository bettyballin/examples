DECLARE
  vsql VARCHAR2(100);
  vname VARCHAR2(30) := 'SYS';
  vresult NUMBER;

BEGIN
  vsql := 'select count(1) from all_objects where owner ='||DBMS_ASSERT.ENQUOTE_LITERAL(vname);
  EXECUTE IMMEDIATE vsql into vresult;
  DBMS_OUTPUT.PUT_LINE(vresult);
END;
/