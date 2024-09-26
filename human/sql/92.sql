-- Create a master key
CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'MasterKey123';

-- Create a certificate
CREATE CERTIFICATE cert_raiser
    ENCRYPTION BY PASSWORD = 'pGFD4bb925DGvbd2439587y'
    WITH SUBJECT = 'raiser', 
    EXPIRY_DATE = '01/01/2114';
GO

-- Create a login from the certificate
CREATE LOGIN cert_login FROM CERTIFICATE cert_raiser;
GO

-- Create a user from the login
CREATE USER cert_user FOR LOGIN cert_login;
GO

-- Add the user to the db_owner role
ALTER ROLE db_owner ADD MEMBER cert_user;
GO

-- Sign the stored procedure with the certificate
ADD SIGNATURE TO SchemaB.GetCustomerOrderInfo 
   BY CERTIFICATE cert_raiser
    WITH PASSWORD = 'pGFD4bb925DGvbd2439587y';
GO