
DELETE wm
FROM webpages_Membership AS wm
LEFT JOIN Users AS u ON wm.UserId = u.UserId
WHERE wm.IsConfirmed = 0
AND wm.CreationDate < DATEADD(day, -20, GETDATE())
AND u.UserId IS NULL;

