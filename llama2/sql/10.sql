CREATE OR REPLACE FUNCTION group_rls()
RETURNS BOOLEAN AS
$$
DECLARE
    member_id INT;
    group_name VARCHAR(50);
BEGIN
    SELECT gm.member_id, gm.group_name 
    INTO member_id, group_name 
    FROM group_members gm 
    WHERE gm.user_name = CURRENT_USER;

    IF FOUND THEN
        RETURN member_id IN (SELECT g.group_id FROM groups g WHERE g.name = group_name);
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE POLICY group_rls ON groups
FOR SELECT
USING (group_rls());