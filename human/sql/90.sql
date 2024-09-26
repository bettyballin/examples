USE master
GO
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'Test')
    CREATE DATABASE Test
GO
USE Test
GO

IF EXISTS (SELECT * FROM sys.syslogins WHERE name = 'UserA')
    DROP LOGIN UserA 
CREATE LOGIN UserA WITH PASSWORD = 'Welcome'
IF EXISTS (SELECT * FROM sys.syslogins WHERE name = 'UserB')
    DROP LOGIN UserB 
CREATE LOGIN UserB WITH PASSWORD = 'Welcome'
IF EXISTS (SELECT * FROM sys.syslogins WHERE name = 'UserC')
    DROP LOGIN UserC 
CREATE LOGIN UserC WITH PASSWORD = 'Welcome'

IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Customers' AND schema_name(schema_id) = 'SchemaA')
    DROP TABLE SchemaA.Customers
IF EXISTS (SELECT * FROM sys.schemas WHERE name = 'SchemaA')
    DROP SCHEMA SchemaA
IF EXISTS (SELECT * FROM sys.sysusers WHERE name = 'UserA')
    DROP USER UserA

IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Orders' AND schema_name(schema_id) = 'SchemaB')
    DROP TABLE SchemaB.Orders
IF EXISTS (SELECT * FROM sys.procedures WHERE name = 'GetCustomerOrderInfo' AND schema_name(schema_id) = 'SchemaB')
    DROP PROCEDURE SchemaB.GetCustomerOrderInfo 
IF EXISTS (SELECT * FROM sys.schemas WHERE name = 'SchemaB')
    DROP SCHEMA SchemaB
IF EXISTS (SELECT * FROM sys.sysusers WHERE name = 'UserB')
    DROP USER UserB

IF EXISTS (SELECT * FROM sys.sysusers WHERE name = 'UserC')
    DROP USER UserC

CREATE USER UserA FOR LOGIN UserA
ALTER ROLE db_owner ADD MEMBER UserA
GO
CREATE SCHEMA SchemaA AUTHORIZATION UserA
GO
CREATE USER UserB FOR LOGIN UserB
ALTER ROLE db_owner ADD MEMBER UserB
GO
CREATE SCHEMA SchemaB AUTHORIZATION UserB
GO
CREATE USER UserC FOR LOGIN UserC

CREATE TABLE SchemaA.Customers (id INT IDENTITY)

CREATE TABLE SchemaB.Orders (id INT IDENTITY, CustomerId INT)
GO
CREATE PROCEDURE SchemaB.GetCustomerOrderInfo 
AS
SELECT  *
FROM    SchemaB.Orders o
JOIN    SchemaA.Customers c
ON      c.id = o.CustomerId
GO