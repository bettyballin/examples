
CREATE OR REPLACE FUNCTION get_emp_pred
(schema_v IN VARCHAR2, tbl_v IN VARCHAR2) RETURN VARCHAR2 AS
    l_predicate VARCHAR2(100);
BEGIN 
    IF SYS_CONTEXT('USERENV', 'CURRENT_USER') = 'BOB' THEN
        l_predicate := 'salary > 1000';
    ELSIF SYS_CONTEXT('USERENV', 'CURRENT_USER') = 'ANNE' THEN
        l_predicate := 'salary < 1000'; 
    ELSE 
        l_predicate := '1=1'; -- This means no restriction for other users
    END IF;
    RETURN l_predicate;
END;

