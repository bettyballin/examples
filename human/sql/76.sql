This is not SQL code, but rather VBA code for Microsoft Access. Here is the code with some minor adjustments to make it executable:

vba
Private Sub LoginBtn_Click()

    If IsNull(Me.LoginCmBx.Value) Or Me.LoginCmBx.Value = "" Then
        MsgBox "You must enter a User Name.", vbOKOnly, "Required Data"
        Me.LoginCmBx.SetFocus
        Exit Sub
    End If

    If IsNull(Me.PasswordTxt.Value) Or Me.PasswordTxt.Value = "" Then
        MsgBox "You must enter a Password.", vbOKOnly, "Required Data"
        Me.PasswordTxt.SetFocus
        Exit Sub
    End If

    If Me.PasswordTxt.Value = DLookup("LoginPassword", "LoginInfoT", "[EmployeeID]=" & Me.LoginCmBx.Value) Then

        Dim EmployeeID As Variant
        EmployeeID = Me.LoginCmBx.Value

        On Error Resume Next
        DoCmd.DeleteObject acQuery, "IsAdminQ"
        On Error GoTo Err_LoginBtn_Click

        Dim qdef As DAO.QueryDef
        Set qdef = CurrentDb.CreateQueryDef("IsAdminQ", _
                                           "SELECT IsAdmin " & _
                                           "FROM LoginInfoT " & _
                                           "WHERE EmployeeID = " & Me.LoginCmBx.Value)

        Exit_LoginBtn_Click:
        DoCmd.Close acForm, "LoginF", acSaveNo
        DoCmd.OpenForm "MenuF"
        Exit Sub

    Err_LoginBtn_Click:
        MsgBox Err.Description
        Resume Exit_LoginBtn_Click

    Else
        MsgBox "Password Invalid. Please Try Again", vbOKOnly, "Invalid Entry!"
        Me.PasswordTxt.SetFocus
    End If

End Sub