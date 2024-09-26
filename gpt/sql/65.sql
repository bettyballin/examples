
CREATE OR REPLACE FUNCTION create_new_user(first_name varchar, last_name varchar, email text)
RETURNS uuid AS $$
DECLARE
  new_user_id uuid;
BEGIN
  INSERT INTO "user"(first_name,
