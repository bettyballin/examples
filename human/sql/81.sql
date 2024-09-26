Here is the corrected code:


-- This is not SQL code, it's VBA code for Microsoft Access

Private Sub Form_Open(Cancel As Integer)
  Me.MyCheckbox.Value = GetLoginStateIsAdmin()
  
  If GetLoginStateIsAdmin() = True Then
    Me.ShortcutMenu = True
  Else
    Me.ShortcutMenu = False
  End If
End Sub


However, if you are looking for SQL code to create a stored procedure that does the same thing, here is an example:


CREATE PROCEDURE SetLoginState
AS
BEGIN
  DECLARE @isAdmin BIT = GetLoginStateIsAdmin();
  
  IF @isAdmin = 1
    SET ShortcutMenu = 1;
  ELSE
    SET ShortcutMenu = 0;
END


Please note that the `GetLoginStateIsAdmin()` function and `ShortcutMenu` field should be defined in your database schema.