csharp
using System;
using System.Web.Security;

class Program
{
    static void Main()
    {
        // Create a new instance of the WindowsTokenRoleProvider
        var provider = new WindowsTokenRoleProvider();

        // Set the provider as the default provider
        Roles.Provider = provider;

        // Enable role management
        Roles.Enabled = true;

        // Disable role caching in cookies
        Roles.CacheRolesInCookie = false;

        Console.WriteLine("Role Manager configured.");
    }
}