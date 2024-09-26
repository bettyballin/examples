PREPARE stmt FROM 'UPDATE users SET active = 1 WHERE email = ? AND hash = ? AND active = 0';
SET @email = 'user@example.com';
SET @hash = 'example_hash';
EXECUTE stmt USING @email, @hash;
DEALLOCATE PREPARE stmt;