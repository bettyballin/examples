DECLARE @query NVARCHAR(MAX)
SET @query = 'SELECT '

-- Create a temp table for metadata
CREATE TABLE #Metadata (
    ID INT,
    [User] VARCHAR(10),
    ColumnName NVARCHAR(MAX)
)

-- Insert data into temp table
INSERT INTO #Metadata (ID, [User], ColumnName)
SELECT ID, [User], ColumnName FROM Metadata

-- Loop through metadata table rows
WHILE EXISTS(SELECT 1 FROM #Metadata WHERE [User] IS NOT NULL AND ColumnName IS NOT NULL) BEGIN

    -- Get the first row from meta data table and remove it from temp table
    DECLARE @user VARCHAR(10), @columnName NVARCHAR(MAX), @id INT
    SELECT TOP 1 @id = ID, @user = [User], @columnName = ColumnName FROM #Metadata ORDER BY ID ASC;
    DELETE FROM #Metadata WHERE ID = @id;

    -- Add column name to the query string with proper delimiter
    IF LEN(@query) > 7 SET @query += ',';
    SET @query += QUOTENAME(@columnName);

END

-- Complete SELECT statement and add table join condition
SET @query += ' FROM MasterDataTable mdt INNER JOIN Metadata md ON mdt.ID = md.ID WHERE md.[User] = ''' + @user + ''';';

-- Execute the dynamic SQL query
EXEC sp_executesql @query;

-- Drop the temp table
DROP TABLE #Metadata;