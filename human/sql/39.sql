USE master
GO
CREATE DATABASE test_database
GO
USE test_database
GO
CREATE LOGIN test_user WITH PASSWORD = 'password123'
GO
CREATE USER test_user FOR LOGIN test_user
GO
EXEC sp_addrolemember 'db_datareader', 'test_user'