
CREATE OR REPLACE FUNCTION get_user_department_id() RETURNS bigint AS $$
DECLARE
    user_department_id bigint;
BEGIN
    SELECT d.id INTO user_department_id
    FROM department d
   
