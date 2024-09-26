SELECT 
  password,
  COUNT(*) AS freq,
  IFNULL((COUNT(*) / t.total) * 100, 0) AS pct_freq
FROM 
  passwords 
  JOIN (
    SELECT COUNT(*) AS total FROM passwords
  ) t 
GROUP BY 
  password
ORDER BY 
  freq DESC 
LIMIT 100;