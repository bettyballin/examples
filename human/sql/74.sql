CREATE TABLE Employees (
  EmployeeID int,
  LoginID int,
  LoginPassword varchar(255),
  EmployeeName varchar(255),
  IsAdmin bit
);

INSERT INTO Employees (EmployeeID, LoginID, LoginPassword, EmployeeName, IsAdmin)
VALUES
  (1, 1111, '1234', 'Bob', 1),
  (2, 2222, '1234', 'Stewert', 0);