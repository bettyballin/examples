csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main()
    {
        string folder = @"\Test";
        string serveurName = "YourServerName";
        string pPrjName = "YourProjectName";
        string serviceAccount = "YourServiceAccount";

        if (folder.IndexOf('\\') == 0)
        {
            string dir = "\\\\" + serveurName + "\\Test-Projects\\" + pPrjName + folder;
            Directory.CreateDirectory(dir);                    
            DirectoryInfo di = new DirectoryInfo(dir);
            DirectorySecurity ds = di.GetAccessControl();                    
            ds.SetOwner(serviceAccount);
            FileSystemAccessRule permissions = new FileSystemAccessRule(serviceAccount, FileSystemRights.FullControl, AccessControlType.Allow);
            ds.AddAccessRule(permissions);
            di.SetAccessControl(ds);
        }
    }
}