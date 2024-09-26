-- Assuming we're using SQLite for this example
-- Create a table for demonstration purposes
CREATE TABLE person (
    firstname TEXT
);

-- Insert a value into the table
INSERT INTO person (firstname) 
VALUES ('John');

-- The con.execute line can be made executable like this:
-- con.execute("INSERT INTO person (firstname) VALUES (?)", ('John',))