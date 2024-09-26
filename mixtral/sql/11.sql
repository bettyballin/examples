CREATE SCHEMA [A] AUTHORIZATION [dbo];
GO

CREATE SCHEMA [B] AUTHORIZATION [dbo];
GO

CREATE TABLE [B].dbo.[any_table] (id INT);
GO

CREATE VIEW [A].[B].some_view
WITH SCHEMABINDING
AS
SELECT * FROM [B].dbo.[any_table]
GO

CREATE USER [user_created_in_step1] WITHOUT LOGIN;
GO

ALTER AUTHORIZATION ON [A].[B].some_view TO [user_created_in_step1];
GO