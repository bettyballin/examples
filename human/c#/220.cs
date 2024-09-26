csharp
using System;
using System.Web;
using System.Web.Security;

class Program
{
    static void Main()
    {
        var expires = DateTime.Now.AddMinutes(30);
        var authenticationTicket = new FormsAuthenticationTicket(1, "username", DateTime.Now, expires, true, "userdata");

        var cookie = new HttpCookie(FormsAuthentication.FormsCookieName, FormsAuthentication.Encrypt(authenticationTicket))
        {
            Path = FormsAuthentication.FormsCookiePath,
            Domain = FormsAuthentication.CookieDomain,
            Secure = FormsAuthentication.RequireSSL,
            Expires = expires,
            HttpOnly = true
        };

        Console.WriteLine(cookie.Name);
        Console.WriteLine(cookie.Value);
        Console.WriteLine(cookie.Path);
        Console.WriteLine(cookie.Domain);
        Console.WriteLine(cookie.Secure);
        Console.WriteLine(cookie.Expires);
        Console.WriteLine(cookie.HttpOnly);
    }
}