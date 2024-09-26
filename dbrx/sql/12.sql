CREATE OR REPLACE FUNCTION check_department_id(p_department_id bigint)
RETURNS boolean AS $$
BEGIN
    RETURN EXISTS (
        SELECT 1 FROM account a JOIN employee e ON (a.employee_id = e.id) WHERE CURRENT_USER::text = a.login AND p_department_id = e.department_id);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION get_employee_ids()
RETURNS SETOF bigint AS $$
DECLARE
    user_login text := CURRENT_USER::text;
BEGIN
    RETURN QUERY SELECT id FROM employee JOIN account ON (employee.id = account.employee_id) WHERE login = user_login;
END;
$$ LANGUAGE plpgsql;

-- Execute the functions
SELECT check_department_id(1);
SELECT get_employee_ids();