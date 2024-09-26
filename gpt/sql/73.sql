
CREATE FUNCTION rls.fn_Data_Predicate
    (@DataProviderID AS INT, @TableName sysname)
RETURNS TABLE
WITH SCHEMABINDING
AS
RETURN
(
    SELECT 1 AS Result
    FROM [fin].[RLS_Data] AS d
    WHERE (
        EXISTS (
            -- Check if the user has admin privileges
            SELECT 1
            FROM [stg].[UserAccess] AS ua
            WHERE ua.[User Email] = CURRENT_USER
            AND ua.isAdmin = 1
        )
        OR (
            EXISTS (
                -- Check if the user has specific access rights
                SELECT 1
                FROM [stg].[UserAccess] AS ua
                WHERE ua.DataProviderId = d.DataProviderID
                AND ua.[User Email] = CURRENT_USER
                AND ua.TableName = @TableName
                AND ua.isAuthorized =
