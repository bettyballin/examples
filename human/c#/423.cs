csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main(string[] args)
    {
        string filename = "test.txt";

        var fileInfo = new FileInfo(filename);
        var security = fileInfo.GetAccessControl();

        // Add a new access rule to the file
        security.AddAccessRule(new FileSystemAccessRule("Everyone", FileSystemRights.Read, AccessControlType.Allow));

        fileInfo.SetAccessControl(security);
    }
}