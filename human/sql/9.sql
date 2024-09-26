DECLARE @sql nvarchar(max);
DECLARE @condition bit = 1;  -- replace with your condition

IF (@condition = 1)
BEGIN
    SET @sql = 'SELECT * FROM myTable WHERE someCol = ''foo''';
END
ELSE
BEGIN
    SET @sql = 'SELECT * FROM myTable WHERE someCol = ''bar''';
END

EXEC sp_executesql @sql;