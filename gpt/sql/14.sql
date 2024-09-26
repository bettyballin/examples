
USE DBName;
GO

-- Create a database user for the existing domain login
CREATE USER [DOMAIN\UserName] FOR LOGIN [DOMAIN\UserName];
GO

-- Grant the user read and write permissions
GRANT SELECT, INSERT, UPDATE, DELETE ON DATABASE::DBName TO [DOMAIN\UserName];
GO

