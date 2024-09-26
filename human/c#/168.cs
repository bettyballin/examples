csharp
using System;
using System.IO;
using System.Security;
using System.Security.Policy;
using System.Security.Permissions;

class Sandbox
{
    static void Main(string[] args)
    {
        string pathToUntrusted = @"C:\Path\To\Untrusted";
        string untrustedAssembly = "UntrustedAssembly";

        Evidence ev = new Evidence();
        ev.AddHostEvidence(new Zone(SecurityZone.Internet));
        PermissionSet internetPS = SecurityManager.GetStandardSandbox(ev);

        AppDomainSetup adSetup = new AppDomainSetup();
        adSetup.ApplicationBase = Path.GetFullPath(pathToUntrusted);

        AppDomain newDomain = AppDomain.CreateDomain("Sandbox Domain", null, adSetup, internetPS);

        newDomain.ExecuteAssemblyByName(untrustedAssembly);
    }
}