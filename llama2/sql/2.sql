DECLARE
  v_cursor SYS_REFCURSOR;
  v_empid your_table.empid%TYPE;
  v_ss your_table.ss%TYPE;
  v_address your_table.address%TYPE;
  v_dept your_table.dept%TYPE;
  v_country your_table.country%TYPE;
BEGIN
  OPEN v_cursor FOR
    SELECT empid, ss, address, dept, country
      FROM your_table
     WHERE country = 'USA';

  LOOP
    FETCH v_cursor INTO v_empid, v_ss, v_address, v_dept, v_country;
    EXIT WHEN v_cursor%NOTFOUND;

    IF v_country = 'USA' THEN
      DBMS_OUTPUT.put('****');
    ELSE
      DBMS_OUTPUT.put(v_empid || ' || ' || v_ss || ' || ' || v_address || ' || ' || v_dept);
    END IF;
  END LOOP;

  CLOSE v_cursor;
END;