CREATE FUNCTION dbo.FN_ListToTable (@Delimiter char(1), @List nvarchar(max))
RETURNS @Table TABLE (Value nvarchar(50))
AS
BEGIN
    DECLARE @Value nvarchar(50)
    DECLARE @Pos int

    SET @List = LTRIM(RTRIM(@List)) + @Delimiter
    SET @Pos = CHARINDEX(@Delimiter, @List, 1)

    IF REPLACE(@List, @Delimiter, '') <> ''
    BEGIN
        WHILE @Pos > 0
        BEGIN
            SET @Value = LTRIM(RTRIM(LEFT(@List, @Pos - 1)))
            IF @Value <> ''
            BEGIN
                INSERT INTO @Table (Value) VALUES (@Value)
            END
            SET @List = RIGHT(@List, LEN(@List) - @Pos)
            SET @Pos = CHARINDEX(@Delimiter, @List, 1)
        END
    END
    RETURN
END
GO

SELECT * FROM dbo.FN_ListToTable(',', '1,2,3,,,4,5,6777,,,')