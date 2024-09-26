-- Create database
CREATE DATABASE Test;
GO

-- Use database
USE Test;
GO

-- Create schemas
CREATE SCHEMA SchemaA;
GO

CREATE SCHEMA SchemaB;
GO

-- Create table
CREATE TABLE SchemaA.Customers (
    CustomerID INT,
    CustomerName VARCHAR(255)
);
GO

-- Insert data
INSERT INTO SchemaA.Customers (CustomerID, CustomerName)
VALUES (1, 'John Doe');
GO

-- Create stored procedure
CREATE PROCEDURE SchemaB.GetCustomerOrderInfo
AS
BEGIN
    SELECT * FROM SchemaA.Customers;
END;
GO

-- Create user
CREATE LOGIN UserC WITH PASSWORD = 'password';
GO

CREATE USER UserC FOR LOGIN UserC;
GO

-- Grant execute permission
GRANT EXECUTE ON SchemaB.GetCustomerOrderInfo TO UserC;
GO

-- Execute stored procedure as UserC
EXECUTE AS LOGIN = 'UserC';
GO

EXEC SchemaB.GetCustomerOrderInfo;
GO

-- Revert execution context
REVERT;
GO