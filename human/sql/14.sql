CREATE FUNCTION [dbo].[FN_ListToTable]
(
     @SplitOn  char(1)      --REQUIRED, the character to split the @List string on
    ,@List     varchar(8000)--REQUIRED, the list to split apart
)
RETURNS TABLE
AS
RETURN 
(
    SELECT
        ListValue
    FROM (
        SELECT
            LTRIM(RTRIM(SUBSTRING(List2, number+1, CHARINDEX(@SplitOn, List2, number+1)-number - 1))) AS ListValue
        FROM (
            SELECT @SplitOn + @List + @SplitOn AS List2
        ) AS dt
        INNER JOIN master..spt_values n ON n.number < LEN(dt.List2)
        WHERE SUBSTRING(List2, number, 1) = @SplitOn
    ) dt2
    WHERE ListValue IS NOT NULL AND ListValue!=''
);
GO