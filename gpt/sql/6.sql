
string CommandText = @"
    SELECT 
        (User.FName + ' ' + User.Surname) AS FullName, 
        Product.Name, 
        Product.Quantity, 
        Product.Price 
    FROM 
        User 
    INNER JOIN 
        Products ON Product.UserID = User.UserID";

