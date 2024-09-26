
SELECT 
    user_princ.name AS principal_name,
    perm.permission_name,
    perm.state_desc,
    proc.name AS procedure_name
FROM 
    sys.database_permissions perm
INNER JOIN 
    sys.procedures proc ON perm.major_id = proc.object_id
INNER JOIN 
    sys.database_principals user_princ ON perm.grantee_principal_id = user_princ.principal_id
WHERE 
    proc.name = 'YourProcedureName' -- Replace with your stored procedure name
ORDER BY 
    principal_name, 
    permission_name;

