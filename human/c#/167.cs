csharp
using System;
using System.Reflection;
using System.Security;
using System.Security.Permissions;
using System.Security.Policy;

class Program
{
    static void Main()
    {
        // Set the friendly name of the new AppDomain
        string friendlyName = "NewAppDomain";

        // Create a new Evidence instance
        Evidence securityInfo = new Evidence();

        // Create a new AppDomainSetup instance
        AppDomainSetup info = new AppDomainSetup();

        // Create a new PermissionSet instance
        PermissionSet grantSet = new PermissionSet(PermissionState.Unrestricted);

        // Create an array of StrongName instances
        StrongName[] fullTrustAssemblies = new StrongName[] { };

        // Create the new AppDomain
        AppDomain newDomain = AppDomain.CreateDomain(friendlyName, securityInfo, info, grantSet, fullTrustAssemblies);

        // Print the friendly name of the new AppDomain
        Console.WriteLine(newDomain.FriendlyName);
    }
}