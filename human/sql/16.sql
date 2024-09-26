CREATE TABLE #Temp (
  ListValue INT
);

INSERT INTO #Temp (ListValue)
VALUES
  (1),
  (2),
  (3),
  (4),
  (5),
  (6777);

SELECT ListValue FROM #Temp;

DROP TABLE #Temp;