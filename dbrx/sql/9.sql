-- Create a sample table
CREATE TABLE my_table (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

-- Enable row-level security
ALTER TABLE my_table ENABLE ROW LEVEL SECURITY;

-- Create a sample role
CREATE ROLE public;

-- Grant privileges to the public role
GRANT SELECT, UPDATE ON my_table TO public WITH GRANT OPTION;