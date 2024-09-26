
-- Given a vulnerable SQL query like this:
SELECT * FROM users WHERE username = '$username' AND password = '$password';

-- An attacker could inject SQL code by entering the following as 'username':
' OR '1'='1' -- 

-- Resulting in the manipulated SQL query:
SELECT * FROM users WHERE username = '' OR '1'='1' -- ' AND password = '$password';

