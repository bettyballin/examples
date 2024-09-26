-- Create a new query
USE [YourDatabaseName]
GO

-- Create a schema A and B if they don't exist
IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'A')
BEGIN
    EXEC('CREATE SCHEMA A');
END
GO

IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'B')
BEGIN
    EXEC('CREATE SCHEMA B');
END
GO

-- Create a view some_view if it doesn't exist
IF NOT EXISTS (SELECT * FROM sys.views WHERE name = 'some_view')
BEGIN
    EXEC('CREATE VIEW A.B.some_view AS SELECT 1 AS id');
END
GO

-- Create a user testuser if it doesn't exist
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = 'testuser')
BEGIN
    CREATE USER testuser FOR LOGIN = 'testuser';
END
GO

-- Grant select permission to testuser on the view
GRANT SELECT ON [A].[B].some_view TO testuser;
GO

-- Execute the query
EXECUTE AS USER = 'testuser';
SELECT * FROM [A].[B].some_view;
REVERT;
GO