USE A;
GO
EXECUTE AS LOGIN = 'testuser';
GO
SELECT *
FROM [A].[B].[some_view];
GO
REVERT;
GO