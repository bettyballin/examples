Unfortunately, the provided code is not SQL, but rather ASP.NET code. However, I'll assume you want to make it executable within a SQL context, possibly as a stored procedure. Here's an equivalent SQL Server code snippet:



CREATE PROCEDURE HtmlEncodeName
    @name nvarchar(255)
AS
BEGIN
    DECLARE @encodedName nvarchar(255)
    SET @encodedName = REPLACE(@name, '&', '&amp;')
    SET @encodedName = REPLACE(@encodedName, '<', '&lt;')
    SET @encodedName = REPLACE(@encodedName, '>', '&gt;')
    SET @encodedName = REPLACE(@encodedName, '"', '&quot;')
    SET @encodedName = REPLACE(@encodedName, '''', '&#39;')
    SELECT @encodedName AS EncodedName
END
GO

EXEC HtmlEncodeName 'John Doe'