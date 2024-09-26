SELECT TOP 10000 IDENTITY(int,1,1) AS Number
    INTO #Numbers
    FROM sys.objects s1
    CROSS JOIN sys.objects s2;

ALTER TABLE #Numbers ADD CONSTRAINT PK_Numbers PRIMARY KEY CLUSTERED (Number);

-- to view the result
SELECT * FROM #Numbers;

-- to drop the temporary table
DROP TABLE #Numbers;