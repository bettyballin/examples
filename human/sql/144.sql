CREATE LOGIN testuser WITH PASSWORD = 'n3$(s(+#BB4--';
GO

USE A;
GO
CREATE USER testuser FOR LOGIN testuser;
ALTER ROLE db_viewreader ADD MEMBER testuser;
GO

USE B;
GO
CREATE USER testuser FOR LOGIN testuser;
GO

USE C;
GO
CREATE USER testuser FOR LOGIN testuser;
GO

USE D;
GO
CREATE USER testuser FOR LOGIN testuser;
GO

USE E;
GO
CREATE USER testuser FOR LOGIN testuser;
GO