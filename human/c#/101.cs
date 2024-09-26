csharp
using System;
using System.Security.AccessControl;
using System.IO;

class Program
{
    static void Main()
    {
        string path = @"C:\Example\Path"; // replace with your directory path
        DirectorySecurity directorySecurity = Directory.GetAccessControl(path);
        directorySecurity.SetAccessRuleProtection(true, false);
        Directory.SetAccessControl(path, directorySecurity);
    }
}