csharp
using System;
using System.Security.Principal;
using System.Web;
using System.Web.Security;
using System.Diagnostics;

class Program
{
    static void Main(string[] args)
    {
        var virtualCachedPath = "/path/to/resource";
        var user = new GenericPrincipal(new GenericIdentity("username"), new string[] { "role1", "role2" });
        var isAllowed = false;

        try
        {
            isAllowed = UrlAuthorizationModule.CheckUrlAccessForPrincipal(virtualCachedPath, user, "GET");
        }
        catch (ArgumentException ex)
        {
            Trace.TraceInformation("VirtualCachedPath: {0}", virtualCachedPath);
            throw;
        }

        Console.WriteLine("Is Allowed: " + isAllowed);
    }
}