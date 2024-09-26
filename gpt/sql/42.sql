
   DELETE FROM sessions WHERE last_accessed < NOW() - INTERVAL 30 DAY;
   
