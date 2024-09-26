DECLARE
  v_in VARCHAR2(2000);
  ret  VARCHAR2(2000);
BEGIN
  v_in := 'KLRICE';
  EXECUTE IMMEDIATE 'SELECT COUNT(1) FROM all_objects WHERE owner = :1' INTO ret USING v_in;
  DBMS_OUTPUT.PUT_LINE('First Object Count  : ' || ret);

  EXECUTE IMMEDIATE 'SELECT COUNT(1) FROM all_objects WHERE owner = ' || DBMS_ASSERT.ENQUOTE_LITERAL(v_in) INTO ret;

  DBMS_OUTPUT.PUT_LINE('Second Object Count  : ' || ret);
END;
/