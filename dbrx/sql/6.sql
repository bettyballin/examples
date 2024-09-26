-- Create database if not exists
CREATE DATABASE IF NOT EXISTS my_database;

-- Connect to the database
USE my_database;

-- Create table
CREATE TABLE my_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    col_a TEXT NOT NULL,
    col_b TEXT NOT NULL,
    protected_col INTEGER DEFAULT 0
);

-- Insert sample data
INSERT INTO my_table (col_a, col_b) 
VALUES 
('Sample A1', 'Sample B1'),
('Sample A2', 'Sample B2'),
('Sample A3', 'Sample B3');

-- Select data
SELECT * FROM my_table;