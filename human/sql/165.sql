DECLARE @DataProviderId INT = 1;
DECLARE @TableName NVARCHAR(50) = 'YourTableName';

SELECT 1 as Result
FROM stg.UserAccess AS u
WHERE u.[User Email] = CURRENT_USER
  AND
  (
    (
      /* admin can see everything regardless of provider: */
      u.IsAdmin = 1 
    )
    OR
    (
      /* only certain users are authorized: */
      u.DataProviderId = @DataProviderId
      AND u.TableName = @TableName
      AND u.isAuthorized = 1
    )
  );