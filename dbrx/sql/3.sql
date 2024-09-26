UPDATE users 
SET is_active = 0 
WHERE cookie = ':cookie_value' 
AND user != ':new_user_id';