csharp
using System;
using System.Security;
using System.Security.Permissions;
using System.Security.Policy;

class Program
{
    static void Main()
    {
        Evidence evidence = new Evidence();
        evidence.AddHostEvidence(new Zone(SecurityZone.Internet));

        PermissionSet permissionSet = SecurityManager.GetStandardSandbox(evidence);

        Console.WriteLine(permissionSet.ToString());
    }
}