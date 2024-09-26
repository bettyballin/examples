
BEGIN;

-- Drop the old policy
DROP POLICY IF EXISTS my_policy ON my_table;

-- Create the new policy
CREATE POLICY my_policy ON my_table
FOR SELECT
USING (user_id = current_user::text);

COMMIT;

