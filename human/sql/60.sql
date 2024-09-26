SELECT COUNT(timestamps) 
FROM table_name 
WHERE timestamp >= NOW() - INTERVAL 5 MINUTE 
GROUP BY ip;