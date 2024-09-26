USE master
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'TestDatabase1')
    DROP DATABASE TestDatabase1
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'TestDatabase2')
    DROP DATABASE TestDatabase2
GO

CREATE DATABASE TestDatabase1
GO

USE TestDatabase1
GO

EXEC sp_changedbowner 'sa'
GO

CREATE PROCEDURE dbo.sp1 AS SELECT 'hello world!'
GO

CREATE DATABASE TestDatabase2
GO

USE TestDatabase2
GO

EXEC sp_changedbowner 'sa'
GO

CREATE PROCEDURE dbo.sp2 AS EXEC TestDatabase1.dbo.sp1
GO

USE TestDatabase2
GO

EXEC sp_grantdbaccess 'testuser'
GO

GRANT EXECUTE ON sp2 TO testuser AS dbo
GO

USE TestDatabase1
GO

EXEC sp_grantdbaccess 'testuser'
GO

USE TestDatabase2
GO

EXECUTE AS LOGIN = 'testuser'
GO

EXEC sp2
GO

REVERT -- Revert back to original login
GO