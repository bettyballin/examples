CREATE TABLE metadata (
  c_user VARCHAR2(50),
  short_desc VARCHAR2(50)
);

CREATE TABLE master_data (
  -- columns corresponding to short_desc in metadata table
);

INSERT INTO metadata (c_user, short_desc) VALUES ('user1', 'column1');
INSERT INTO metadata (c_user, short_desc) VALUES ('user1', 'column2');
INSERT INTO metadata (c_user, short_desc) VALUES ('user2', 'column3');

CREATE OR REPLACE FUNCTION f_meta (par_user IN VARCHAR2)
RETURN SYS_REFCURSOR
IS
  l_str VARCHAR2(200);
  rc SYS_REFCURSOR;
BEGIN
  SELECT LISTAGG(short_desc, ', ') WITHIN GROUP (ORDER BY NULL)
  INTO l_str
  FROM metadata
  WHERE c_user = par_user;

  l_str := 'SELECT ' || l_str ||' FROM master_data';

  OPEN rc FOR l_str;
  RETURN rc;
END;
/

-- Test the function
DECLARE
  rc SYS_REFCURSOR;
BEGIN
  rc := f_meta('user1');
  LOOP
    FETCH rc INTO -- variables corresponding to columns in master_data table
    EXIT WHEN rc%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(-- variables corresponding to columns in master_data table);
  END LOOP;
  CLOSE rc;
END;
/