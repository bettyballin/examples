csharp
using System;
using System.Security.Principal;
using System.Web.Security;

public class Program
{
    public static void Main()
    {
        var user = new GenericPrincipal(new GenericIdentity("YourUsername"), null);
        if (!IsProfileComplete(WebSecurity.GetUserId(user.Identity.Name)))
        {
            Console.WriteLine("Profile is not complete");
        }
        else
        {
            Console.WriteLine("Profile is complete");
        }
    }

    public static bool IsProfileComplete(int userId)
    {
        // your implementation here
        return true; // or false
    }
}

public static class WebSecurity
{
    public static int GetUserId(string username)
    {
        // your implementation here
        return 1; // or any other id
    }
}