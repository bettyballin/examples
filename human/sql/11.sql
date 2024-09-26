-- Create a sample database and table
CREATE DATABASE SampleDB;
GO

USE SampleDB;
GO

CREATE TABLE SampleTable (
    Field_Name nvarchar(50)
);

-- Insert some sample data
INSERT INTO SampleTable (Field_Name) VALUES ('SampleValue1');
INSERT INTO SampleTable (Field_Name) VALUES ('SampleValue2');

-- The corrected SQL query
SELECT SampleTable.Field_Name
FROM SampleTable;