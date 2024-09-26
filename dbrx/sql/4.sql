-- Create a sample users table
CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY,
  user_cookie VARCHAR(255),
  is_active INT
);

-- Insert some sample data
INSERT INTO users (id, user_cookie, is_active) VALUES (1, 'sample_cookie', 1);

-- Define variables
SET @user_id = 1;
SET @new_user_id = 2;
SET @cookie_value = 'new_cookie';

-- DELETE statement
DELETE FROM users WHERE id = @user_id AND is_active = 1;

-- INSERT statement (fixed syntax)
INSERT INTO users (id, user_cookie) VALUES (@new_user_id, @cookie_value);