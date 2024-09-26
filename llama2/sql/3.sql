DECLARE @sql nvarchar(max);
DECLARE @sortcolumn nvarchar(50);

SET @sortcolumn = 'your_column_name';  -- replace 'your_column_name' with the actual column name

SET @sql = N'SELECT * FROM tbl6 ORDER BY ' + QUOTENAME(@sortcolumn);

EXEC sp_executesql @sql;