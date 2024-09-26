DECLARE @currentUserId INT = CONVERT(INT, CURRENT_USER);

SELECT @companyId = CompanyID 
FROM Companies 
WHERE UserID = @currentUserId;