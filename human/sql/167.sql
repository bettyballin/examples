CREATE TABLE dbo.RLS_Data
(
    ProductId int, 
    DistributorId int, 
    DataProviderId int
);

INSERT INTO dbo.RLS_Data (ProductId, DistributorId, DataProviderId)
VALUES
(54069, 10000001, 10),
(50444, 10000002, 40),
(86603, 10000003, 10),
(44753, 10000004, 40),
(86589, 10000005, 10);

CREATE TABLE dbo.UserAccess
(
    Id int IDENTITY(1,1),
    [User Email] sysname,
    DataProviderId int,
    TableName sysname,
    isAuthorized bit,
    isAdmin bit
);

INSERT INTO dbo.UserAccess ([User Email], DataProviderId, TableName, isAuthorized, isAdmin)
VALUES
('bob_the_admin', 10, 'RLS_Data', 1, 1),
('jim_the_peon',  40, 'RLS_Data', 1, 0);