CREATE OR REPLACE VIEW curr_department AS
    (SELECT department_id as id FROM employee WHERE id =
        (SELECT employee_id FROM account WHERE login = current_user)
    );

CREATE OR REPLACE POLICY locale_policy ON employee
    TO justuser, operator
    USING (department_id =
        (SELECT id FROM curr_department)
    );