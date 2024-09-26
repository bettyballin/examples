CREATE USER my_test_user WITHOUT LOGIN;
SELECT USER_NAME(), USER, SUSER_SNAME(),SYSTEM_USER, suser_name();
EXECUTE AS USER = 'my_test_user' WITH NO REVERT;
GO
SELECT USER_NAME(), USER, SUSER_SNAME(),SYSTEM_USER, suser_name(),
                        SUSER_SID();
GO
SELECT * FROM sys.database_principals WHERE sid = SUSER_SID();
REVERT;