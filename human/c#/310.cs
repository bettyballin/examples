csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main(string[] args)
    {
        var sid = new SecurityIdentifier(WellKnownSidType.AuthenticatedUserSid, null);

        var fileSystemAccessRule = new FileSystemAccessRule(
            sid,
            FileSystemRights.Modify,
            InheritanceFlags.ContainerInherit | InheritanceFlags.ObjectInherit,
            PropagationFlags.None,
            AccessControlType.Allow);

        var directoryInfo = new DirectoryInfo(".");
        var directorySecurity = directoryInfo.GetAccessControl();
        directorySecurity.AddAccessRule(fileSystemAccessRule);
        directoryInfo.SetAccessControl(directorySecurity);
    }
}