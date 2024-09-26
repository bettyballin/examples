CREATE PROCEDURE YourProcedure
    @ProfileID INT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @SQL NVARCHAR(MAX) = N'
        SELECT * FROM User1.YourTable WHERE ProfileID = @ProfileID;
    ';

    EXEC sp_executesql @SQL, N'@ProfileID INT', @ProfileID = @ProfileID;
END
GO

GRANT EXECUTE ON OBJECT::YourProcedure TO [Domain\User1];