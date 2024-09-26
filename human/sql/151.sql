PREPARE stmt FROM 'SELECT * FROM user_table WHERE id = ? AND pw = ?';
SET @id = 'your_id';
SET @pwd = 'your_password';
EXECUTE stmt USING @id, @pwd;
DEALLOCATE PREPARE stmt;