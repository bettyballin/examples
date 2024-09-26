DECLARE @email nvarchar(255) = 'example@email.com';

SELECT u.Email,
CASE WHEN a.user_id is null then 'Role_User'
WHEN a.auth_type = 'S' then 'Role_Admin'
WHEN a.auth_type = 'L' then 'Role_Licensee' end as 'authority'
FROM users u LEFT JOIN auth_sys a on u.user_id = a.user_id
WHERE u.email = @email;