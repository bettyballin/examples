-- Assuming $sql is a PDOStatement object and $db is a PDO object

DECLARE @sql NVARCHAR(MAX);
SET @sql = 'SELECT * FROM your_table';

BEGIN TRY
    EXEC sp_executesql @sql;
END TRY
BEGIN CATCH
    DECLARE @errMsg NVARCHAR(4000);
    SET @errMsg = ERROR_MESSAGE();
    RAISERROR (@errMsg, 16, 1);
END CATCH;