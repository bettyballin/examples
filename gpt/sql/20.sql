
   -- Connect to the master database to create a new login
   CREATE LOGIN [AdminUser] WITH PASSWORD = 'password_here';
   
   -- Connect to your database to create a new user from the login
   CREATE USER [AdminUser] FOR LOGIN [AdminUser];
   EXEC sp_addrolemember 'db_owner', 'AdminUser'; --
