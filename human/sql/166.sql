CREATE LOGIN bob_the_admin   WITH PASSWORD = 'boo', CHECK_POLICY = OFF;
CREATE LOGIN jim_the_peon    WITH PASSWORD = 'boo', CHECK_POLICY = OFF;
CREATE LOGIN ted_the_outcast WITH PASSWORD = 'boo', CHECK_POLICY = OFF;
GO

CREATE DATABASE foo;
GO

USE foo;
GO

CREATE USER bob_the_admin FOR LOGIN bob_the_admin;
CREATE USER jim_the_peon FOR LOGIN jim_the_peon;
CREATE USER ted_the_outcast FOR LOGIN ted_the_outcast;
GO

ALTER ROLE db_datareader ADD MEMBER bob_the_admin;
ALTER ROLE db_datareader ADD MEMBER jim_the_peon;
ALTER ROLE db_datareader ADD MEMBER ted_the_outcast;
GO