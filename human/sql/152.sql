-- This is not a SQL code, it's a PHP code. 
-- However, here's a SQL code that does something similar:

BEGIN TRY
    EXEC ($sql)
END TRY
BEGIN CATCH
    DECLARE @ErrorMessage nvarchar(4000)
    SET @ErrorMessage = ERROR_MESSAGE()
    RAISERROR (@ErrorMessage, 16, 1)
END CATCH