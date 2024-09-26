DECLARE
  vsql VARCHAR2(1000);
  vname VARCHAR2(100) := 'product_name';
  vdescription VARCHAR2(100);
BEGIN
  vsql := 'SELECT description FROM products WHERE name=''' || vname || '''';
  EXECUTE IMMEDIATE vsql INTO vdescription;
  DBMS_OUTPUT.PUT_LINE(vdescription);
END;