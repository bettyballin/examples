USE master
CREATE LOGIN mylogin WITH PASSWORD = 'mypassword';
USE mydatabase
CREATE USER myuser FOR LOGIN mylogin;