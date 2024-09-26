csharp
using System;
using System.IO;
using System.Security.AccessControl;

class Program
{
    static void Main(string[] args)
    {
        FileSecurity security = File.GetAccessControl(@"C:\MyFolder\My File.txt");

        AuthorizationRuleCollection acl = security.GetAccessRules(
           true, true, typeof(System.Security.Principal.NTAccount));
        foreach (FileSystemAccessRule ace in acl)
        {
           var user = ace.IdentityReference.Value;
           var rights = ace.FileSystemRights;
           var allowOrDeny = ace.AccessControlType;
           Console.WriteLine($"User: {user}, Rights: {rights}, Allow/Deny: {allowOrDeny}");
        }
    }
}