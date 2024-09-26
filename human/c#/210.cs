csharp
using System;
using System.Security;
using System.Security.Permissions;

class Program
{
    static void Main()
    {
        PermissionSet permissionSet = new PermissionSet(PermissionState.None);
        permissionSet.AddPermission(new SecurityPermission(SecurityPermissionFlag.Execution));
    }
}