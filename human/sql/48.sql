CREATE TABLE Employees (
  EmpID INT,
  Country VARCHAR(255)
);

INSERT INTO Employees (EmpID, Country)
VALUES
  (1, 'USA'),
  (2, 'Canada'),
  (3, 'USA'),
  (4, 'Mexico');

SELECT 
  CASE 
    WHEN Country = 'USA' THEN '*****' 
    ELSE CONVERT(VARCHAR(255), EmpID)
  END as EmpID
FROM Employees;