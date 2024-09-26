-- Find the owner of a specific database
SELECT  d.name AS DatabaseName
,       l.name AS OwnerName
FROM    sys.databases d
JOIN    sys.syslogins l
ON      d.owner_sid = l.sid
WHERE   d.name LIKE 'YourDatabaseName'

-- Find the owner of a specific stored procedure
SELECT  p.name AS ProcedureName
,       dp.name AS OwnerName
FROM    YourDatabaseName.sys.procedures p
JOIN    YourDatabaseName.sys.schemas s
ON      s.schema_id = p.schema_id
JOIN    YourDatabaseName.sys.database_principals dp
ON      s.principal_id = dp.principal_id
WHERE   p.name LIKE 'YourStoredProcedureName'