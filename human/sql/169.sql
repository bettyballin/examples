CREATE TABLE dbo.UserAccess (
    UserName VARCHAR(50),
    DepartmentId INT,
    AccessLevel VARCHAR(50),
    IsActive BIT,
    IsAdmin BIT
);

INSERT INTO dbo.UserAccess VALUES
('ted_the_outcast', 10, 'RLS_Data', 0, 0);