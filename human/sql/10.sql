DECLARE @myParam nvarchar(50)

IF SomeCondition
    SET @myParam = 'foo'
ELSE
    SET @myParam = 'bar'

SELECT * FROM myTable WHERE someCol = @myParam