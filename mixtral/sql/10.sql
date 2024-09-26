-- Connecting to MySQL
mysql -u username -p

-- Create a database if it doesn't exist
CREATE DATABASE IF NOT EXISTS mydatabase;

-- Use the database
USE mydatabase;

-- Create a users table if it doesn't exist
CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

-- Insert some data into the users table
INSERT INTO users (name) VALUES ('John Doe');
INSERT INTO users (name) VALUES ('Jane Doe');

-- Create a stored procedure
DELIMITER //
CREATE PROCEDURE GetUser(IN user_id INT)
BEGIN
  SELECT * FROM users WHERE id = user_id;
END//
DELIMITER ;

-- Set the input argument
SET @userID = 1;

-- Call the created procedure with input argument
CALL GetUser(@userID);