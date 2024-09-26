PREPARE stmt FROM 'UPDATE users SET is_active = 1 WHERE id = ?';
SET @user_id = 123;  
EXECUTE stmt USING @user_id;
DEALLOCATE PREPARE stmt;