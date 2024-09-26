
SELECT DISTINCT U.email AS 'username', 
    CASE 
        WHEN A.auth_type IS NULL THEN 'ROLE_USER'
        WHEN A.auth_type = 'S' THEN 'ROLE_SYSADMIN'
        WHEN A.auth_type = 'L' THEN 'ROLE_LICENSEE'
    END AS 'authority'
FROM users U
LEFT JOIN auth_sys A ON U.user_id = A.user_id AND A.auth_type IN ('L', 'S')
WHERE U.email = ?
UNION
SELECT U.email, 'ROLE_USER'
FROM users U
WHERE U.email = ? AND NOT EXISTS (
    SELECT 1 FROM auth_sys A WHERE U.user_id = A.user_id AND A.auth_type IN ('L', 'S')
)

