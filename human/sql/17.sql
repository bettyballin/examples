DECLARE @MyList VARCHAR(MAX) = '1,2,3,4,5';

SELECT * 
FROM tblMyTable 
INNER JOIN /*Bunch of inner joins here*/ 
WHERE ItemID IN (
    SELECT ListValue 
    FROM dbo.FN_ListToTable(',', @MyList)
);