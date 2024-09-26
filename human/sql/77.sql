This is not SQL code, it's VBA code for Microsoft Access. However, here is the corrected code:

vba
Private Sub MenuLogOutBtn_Click()
    On Error Resume Next
    DoCmd.DeleteObject acQuery, "IsAdminQ"
    DoCmd.OpenForm "LoginF"
    DoCmd.Close acForm, "MenuF", acSaveNo
    On Error GoTo 0
End Sub