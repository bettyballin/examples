SET @ip = '192.168.1.1';  -- replace with the desired IP address

SELECT COUNT(*) 
FROM login_attempts 
WHERE ip = @ip 
AND lastaccess >= NOW() - INTERVAL 5 MINUTE;