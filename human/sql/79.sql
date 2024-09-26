Here is the corrected and executable SQL code:


**LoginModule**
vb
Option Explicit
Public EmployeeID As Long


**GetAdmin**
vb
Option Explicit

Function GetLoginStateIsAdmin() As Boolean
    Dim rst As DAO.Recordset

    Set rst = CurrentDb.OpenRecordset("IsAdminQ")
    GetLoginStateIsAdmin = Nz(rst(0), False)

    Set rst = Nothing
End Function


**DisableShift**
vb
Option Explicit

Function ap_DisableShift() As Boolean
    On Error GoTo errDisableShift

    Dim db As DAO.Database
    Dim prop As DAO.Property
    Const conPropNotFound = 3270

    Set db = CurrentDb()

    'This next line disables the shift key on startup.
    db.Properties("AllowByPassKey") = False

    'The function is successful.
    Exit Function

errDisableShift:
    'The first part of this error routine creates the "AllowByPassKey
    'property if it does not exist.
    If Err = conPropNotFound Then
        Set prop = db.CreateProperty("AllowByPassKey", _
            dbBoolean, False)
        db.Properties.Append prop
        Resume Next
    Else
        MsgBox "Function 'ap_DisableShift' did not complete successfully."
        Exit Function
    End If
End Function