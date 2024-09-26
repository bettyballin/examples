csharp
using System;
using System.Security.AccessControl;
using Microsoft.Win32;

class Program
{
    static void Main()
    {
        string subkey = @"SOFTWARE\YourSubKey"; // replace with your subkey
        RegistryKey LocalMachine = Registry.LocalMachine;

        RegistryKey rk = LocalMachine.OpenSubKey(subkey, RegistryKeyPermissionCheck.ReadWriteSubTree, RegistryRights.ChangePermissions | RegistryRights.ReadKey);
        RegistrySecurity rs = new RegistrySecurity();
        rs.AddAccessRule(new RegistryAccessRule("Administrator", RegistryRights.FullControl, InheritanceFlags.ContainerInherit | InheritanceFlags.ObjectInherit, PropagationFlags.InheritOnly, AccessControlType.Allow));
        rk.SetAccessControl(rs);
        rk = LocalMachine.OpenSubKey(subkey, RegistryKeyPermissionCheck.ReadWriteSubTree, RegistryRights.FullControl);
        rs.SetOwner(new NTAccount("Administrator"));
        rk.SetAccessControl(rs);
    }
}