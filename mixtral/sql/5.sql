CREATE DATABASE database_name;
GO

USE database_name;
GO

CREATE TABLE table_name (
    column1 INT,
    column2 VARCHAR(255)
);
GO

CREATE VIEW view_name
AS SELECT column1, column2
FROM table_name;
GO

ALTER VIEW view_name
AS SELECT column1, column2
FROM table_name
WITH CASCADED CHECK OPTION
SQL SECURITY INVOKER;
GO