csharp
using System.Web.Security;

class Program
{
    static void Main()
    {
        string username = "JohnDoe"; // replace with actual service call
        string role = "Admin"; // replace with actual service call
        bool keepUserLoggedIn = true; // replace with actual value

        FormsAuthentication.SetAuthCookie(username + "-" + role, keepUserLoggedIn);
    }
}