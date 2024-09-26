csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main()
    {
        byte[] DecryptedXML = System.Text.Encoding.UTF8.GetBytes("Your decrypted XML content");

        using (FileStream oFileStreamDec = new FileStream(@"C:\Decrypted_AMS.cfg", FileMode.Create, FileAccess.ReadWrite, FileShare.None))
        {
            oFileStreamDec.Write(DecryptedXML, 0, DecryptedXML.Length);
        }

        FileSecurity oFileSecurity = new FileSecurity();
        oFileSecurity.AddAccessRule(new FileSystemAccessRule("Everyone", FileSystemRights.FullControl, AccessControlType.Allow));
        File.SetAccessControl(@"C:\Decrypted_AMS.cfg", oFileSecurity);
    }
}