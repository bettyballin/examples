
SET @total_count := (SELECT COUNT(*) FROM your_password_table);

SELECT 
    password,
    COUNT(*) as occurrences,
    ROUND(100 * (SUM(COUNT(*)) OVER (ORDER BY COUNT(*) DESC, password ASC) / @total_count), 2) as percentile
FROM 
    your_password_table
GROUP BY 
    password
ORDER BY 
    occurrences DESC, 
    password ASC;

