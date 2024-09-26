
CREATE OR REPLACE PROCEDURE your_procedure_name (
    your_out_cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN your_out_cursor FOR
    SELECT
        CASE WHEN country = 'USA' THEN '****' ELSE empid END AS empid,
        CASE WHEN country = 'USA' THEN '****' ELSE ss END AS ss,
        CASE WHEN country = 'USA' THEN '****' ELSE address END AS address,
        CASE WHEN country = 'USA' THEN '****' ELSE dept END AS dept,
        -- Include other columns that do not need to be masked
        column5,
        column6,
        column7,
        country -- Include the country column if needed
    FROM your_table_name;
END your_procedure_name;

