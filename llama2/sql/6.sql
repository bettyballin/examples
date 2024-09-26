-- Create the role
CREATE ROLE my_role WITH PASSWORD 'some_password';

-- Grant usage on schema api to my_role
GRANT USAGE ON SCHEMA api TO my_role;

-- Grant select on api.mytable to my_role
GRANT SELECT ON api.mytable TO my_role;

-- Set the current role to my_role
SET ROLE my_role;

-- Now you can test the permissions by running a query
SELECT * FROM api.mytable;