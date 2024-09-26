csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main()
    {
        string directoryPath = @"C:\path\to\directory";
        DirectorySecurity ds = Directory.GetAccessControl(directoryPath);
        FileSystemAccessRule ar = new FileSystemAccessRule("Everyone", FileSystemRights.Read, AccessControlType.Allow);

        ds.RemoveAccessRule(ar);
        ds.SetAccessRuleProtection(true, false);

        Directory.SetAccessControl(directoryPath, ds);
    }
}