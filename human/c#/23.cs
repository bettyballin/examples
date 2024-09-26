csharp
using System;
using System.IO;
using System.Security.Principal;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var directories = GetDirectories(@"C:\Path\To\Search");
        foreach (var directory in directories)
        {
            Console.WriteLine(directory);
        }
    }

    public static List<string> GetDirectories(string searchPath)
    {
        using (WindowsImpersonationContext wic = GetIdentity().Impersonate())
        {
            var directories = new List<string>();

            var di = new DirectoryInfo(searchPath);
            directories.AddRange(di.GetDirectories().Select(d => d.FullName));

            return directories;
        }
    }

    public static WindowsIdentity GetIdentity()
    {
        // You need to implement this method to get the WindowsIdentity
        // For demonstration purposes, I'm using the current user's identity
        return WindowsIdentity.GetCurrent();
    }
}