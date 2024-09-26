-- Create the UserAccess table
CREATE TABLE dbo.UserAccess (
    [User Email] nvarchar(255),
    IsAdmin bit,
    DataProviderId int,
    TableName sysname,
    isAuthorized bit
);
GO

-- Create the RLS_Data table
CREATE TABLE dbo.RLS_Data (
    DataProviderID int,
    -- Add other columns as needed
);
GO

-- Create the function
CREATE OR ALTER FUNCTION dbo.FN_RLS_LetThemIn
(
    @DataProviderId int,
    @TableName sysname
)
RETURNS TABLE WITH SCHEMABINDING
AS RETURN 
   (
     SELECT 1 as Result
       FROM dbo.UserAccess AS u
       WHERE u.[User Email] = SUSER_NAME()
       AND
       (
         (
           u.IsAdmin = 1 
         )
         OR
         (
           u.DataProviderId = @DataProviderId
           AND u.TableName = @TableName
           AND u.isAuthorized = 1
         )
       )
   );
GO

-- Create the security policy
CREATE SECURITY POLICY RLS_LetThemIn
    ADD FILTER PREDICATE dbo.FN_RLS_LetThemIn(DataProviderID, N'RLS_Data')
    ON [dbo].[RLS_Data]
    WITH (STATE = ON);
GO

-- Insert some sample data
INSERT INTO dbo.UserAccess ([User Email], IsAdmin, DataProviderId, TableName, isAuthorized)
VALUES ('your_email@example.com', 1, 1, 'RLS_Data', 1);
GO

INSERT INTO dbo.RLS_Data (DataProviderID)
VALUES (1), (2);
GO

-- Test the security policy
SELECT * FROM dbo.RLS_Data;
GO