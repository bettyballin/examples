DECLARE @sortcolumn nvarchar(50) = 'arguments.sortcolumn';

IF NOT EXISTS (
  SELECT 1 
  FROM STRING_SPLIT('list|of|valid|values|here', '|') 
  WHERE value = @sortcolumn
)
BEGIN
  RAISERROR ('Invalid sort column', 16, 1);
END;