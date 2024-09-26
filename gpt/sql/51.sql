
CREATE VIEW employee_with_department AS
SELECT e.*, a.login
FROM employee e
JOIN account a ON e.id = a.employee_id
JOIN department d ON e.department_id = d.id;

