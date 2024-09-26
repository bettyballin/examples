-- Create separate schemata for each user or group of related tables.
CREATE SCHEMA User1 AUTHORIZATION dbo;
GO

-- Create a sample table for demonstration purposes.
CREATE TABLE dbo.YourTable (
    Id INT PRIMARY KEY,
    Name VARCHAR(100)
);
GO

-- Grant permissions on the schemas instead of individual objects (tables/views).
GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::User1 TO [Domain\User1];
GO

-- Move relevant table(s) to their respective schemata.
ALTER SCHEMA User1 TRANSFER dbo.YourTable;
GO