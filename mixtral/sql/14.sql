CREATE FUNCTION rls.fn_Data_Predicate
          (@DataProviderID AS INT, @TableName sysname)
RETURNS TABLE
WITH SCHEMABINDING
AS
RETURN
(
     SELECT 1 as Result
     FROM [fin].[RLS_Data] d
     WHERE
         (CURRENT_USER IN ('dbo', 'DBENTPBIPROD') OR
          EXISTS
             (SELECT *
              FROM stg.UserAccess e
              WHERE
                   e.[User Email] = CURRENT_USER
               AND
                  ((e.isAdmin = 1)
                    OR
                     (d.DataProviderID = @DataProviderID
                      AND
                       e.TableName = @TableName
                        AND
                         e.isAuthorized = 1
                          )
               ))
          );
);
GO