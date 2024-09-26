-- Create the custom role
CREATE ROLE db_customRole;

-- Grant SELECT permission on the sys schema to the custom role
GRANT SELECT ON SCHEMA::sys TO db_customRole;

-- Deny VIEW ANY DEFINITION permission to the public role
DENY VIEW ANY DEFINITION TO PUBLIC;

-- Alter the authorization of the database to sa
ALTER AUTHORIZATION ON DATABASE::YourDatabaseName TO [sa];

-- Add the Foo user to the custom role
EXEC sp_addrolemember 'db_customRole', 'Foo';