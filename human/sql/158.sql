CREATE OR REPLACE FUNCTION get_emp_pred
(schema_v IN VARCHAR2, tbl_v IN VARCHAR2) RETURN VARCHAR2 AS
    l_predicate VARCHAR2(100);
BEGIN 
    IF 'BOB' = SYS_CONTEXT('USERENV', 'SESSION_USER') THEN
        l_predicate := 'salary > 1000';
    ELSIF 'ANNE' = SYS_CONTEXT('USERENV', 'SESSION_USER') THEN
        l_predicate := 'salary < 1000'; 
    ELSE 
        l_predicate := '1=1';
    END IF;
    RETURN l_predicate;
END;
/