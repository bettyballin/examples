csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main()
    {
        string DirectoryName = @"C:\Path\To\Directory";
        AddDirectorySecurity(DirectoryName, @"MYDOMAIN\MyAccount", FileSystemRights.ReadData, AccessControlType.Allow);
    }

    static void AddDirectorySecurity(string FileName, string Account, FileSystemRights Rights, AccessControlType ControlType)
    {
        // Create a new DirectoryInfo object.
        DirectoryInfo dInfo = new DirectoryInfo(FileName);

        // Get a DirectorySecurity object that represents the 
        // current security settings.
        DirectorySecurity dSecurity = dInfo.GetAccessControl();

        // Add the FileSystemAccessRule to the security settings. 
        dSecurity.AddAccessRule(new FileSystemAccessRule(Account,
                                                        Rights,
                                                        ControlType));

        // Set the new access settings.
        dInfo.SetAccessControl(dSecurity);
    }
}