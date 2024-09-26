-- Create a sample database
CREATE DATABASE sample_db;

-- Use the sample database
USE sample_db;

-- Create the group_members table
CREATE TABLE group_members (
    member_id INT PRIMARY KEY,
    user_name VARCHAR(50),
    group_name VARCHAR(50)
);

-- Insert some sample data
INSERT INTO group_members (member_id, user_name, group_name)
VALUES 
(1, 'John Doe', 'Admin'),
(2, 'Jane Doe', 'Moderator'),
(3, 'Bob Smith', 'User');

-- Select all data from the group_members table
SELECT * FROM group_members;