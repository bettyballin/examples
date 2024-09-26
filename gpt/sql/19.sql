
   -- Enable cross-db ownership chaining for the entire server
   EXEC sp_configure 'cross db ownership chaining', 1;  
   RECONFIGURE;

   -- Enable cross-db ownership chaining for each database
   ALTER DATABASE DatabaseA SET DB_CHAINING ON;
   ALTER DATABASE DatabaseB SET DB_CHAINING ON;
   
