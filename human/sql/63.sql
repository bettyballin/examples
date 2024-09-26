SELECT wm.* 
FROM webpages_Membership wm 
INNER JOIN Users u 
ON wm.UserID = u.UserID 
WHERE wm.IsConfirmed = 'false' 
AND DATEADD(dd, 20, wm.CreationDate) <= GETDATE();