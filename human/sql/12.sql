-- Create a sample table
CREATE TABLE YourTable (
    ID INT PRIMARY KEY,
    Name VARCHAR(255)
);

-- Insert some sample data
INSERT INTO YourTable (ID, Name)
VALUES (1, 'John'), (2, 'Jane'), (3, 'Bob');

-- Create a sample split function
CREATE FUNCTION yourSplitFunction (@Parameter VARCHAR(MAX))
RETURNS @Result TABLE (Value INT)
AS
BEGIN
    DECLARE @XML XML
    SET @XML = CONVERT(XML, '<root><value>' + REPLACE(@Parameter, ',', '</value><value>') + '</value></root>')

    INSERT INTO @Result (Value)
    SELECT T.c.value('.', 'INT') AS Value
    FROM @XML.nodes('/root/value') T(c)

    RETURN
END

-- Declare the parameter and execute the query
DECLARE @Parameter VARCHAR(MAX) = '1,2'

SELECT
    *
FROM YourTable y
INNER JOIN dbo.yourSplitFunction(@Parameter) s ON y.ID = s.Value