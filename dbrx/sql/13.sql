-- Create a sample database
CREATE DATABASE test_db;

-- Connect to the database
\c test_db

-- Create a sample table
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    department_id INTEGER
);

-- Create a sample function for the policy
CREATE OR REPLACE FUNCTION check_department_id(department_id INTEGER)
RETURNS BOOLEAN AS $$
BEGIN
    RETURN department_id = 1;  -- Sample condition
END;
$$ LANGUAGE plpgsql;

-- Create the policy
CREATE POLICY locale_policy ON employee AS PERMISSIVE TO PUBLIC USING (
    check_department_id(department_id)
);

-- Create a sample user
CREATE ROLE justuser;

-- Assign the policy to the user
GRANT ALL PRIVILEGES ON employee TO justuser;

-- Set the current role
SET ROLE justuser;

-- Test the policy
INSERT INTO employee (name, department_id) VALUES ('John Doe', 1);
INSERT INTO employee (name, department_id) VALUES ('Jane Doe', 2);