-- Create schema
CREATE SCHEMA IF NOT EXISTS private;

-- Create role
CREATE ROLE IF NOT EXISTS my_role;

-- Create table
CREATE TABLE IF NOT EXISTS private.mytable (
    id SERIAL PRIMARY KEY,
    data VARCHAR(255)
);

-- Create policy
CREATE POLICY IF NOT EXISTS mytable_policy ON private.mytable
    FOR SELECT
    USING (pg_has_role('my_role', 'member'));

-- Alter policy
ALTER POLICY mytable_policy ON private.mytable
    FOR SELECT
    USING (pg_has_role('my_role', 'member'));