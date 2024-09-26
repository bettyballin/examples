-- Create a sample stored procedure
CREATE PROCEDURE MyProc
AS
BEGIN
    SELECT 'Hello World!'
END
GO

-- Grant some permissions to the procedure
GRANT EXECUTE ON MyProc TO PUBLIC
GO

-- Query the permissions
SELECT
    OBJECT_NAME(major_id), USER_NAME(grantee_principal_id), permission_name
FROM
    sys.database_permissions p
WHERE
    OBJECT_NAME(major_id) = 'MyProc'
GO

-- Clean up
DROP PROCEDURE MyProc
GO