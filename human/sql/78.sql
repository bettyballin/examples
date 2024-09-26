This is not SQL code, it's VBA (Visual Basic for Applications) code for Microsoft Access. Here is the corrected version:

vba
Private Sub Form_Open(Cancel As Integer)
    Me.MyCheckbox.Value = GetLoginStateIsAdmin()
    
    If GetLoginStateIsAdmin() = True Then
        Me.ShortcutMenu = True
        DoCmd.ShowToolbar "Ribbon", acToolbarYes
        DoCmd.ShowToolbar "Menu Bar", acToolbarYes
        Application.SetOption "ShowWindowsinTaskbar", True
        DoCmd.SelectObject acTable, , True
    Else
        Me.ShortcutMenu = False
        DoCmd.ShowToolbar "Ribbon", acToolbarNo
        DoCmd.ShowToolbar "Menu Bar", acToolbarNo
        Application.SetOption "ShowWindowsinTaskbar", False
        DoCmd.NavigateTo "acNavigationCategoryObjectType"
        DoCmd.RunCommand acCmdWindowHide
    End If
End Sub