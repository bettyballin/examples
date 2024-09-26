csharp
using System;
using System.Web;

public class Program
{
    public static bool CheckFormsCookie(HttpContext httpContext)
    {
        var formsCookie = httpContext.Request.Cookies[FormsAuthentication.FormsCookieName];
        if (formsCookie == null)
            return false;
        return true;
    }

    public static void Main(string[] args)
    {
        HttpContext httpContext = HttpContext.Current;
        Console.WriteLine(CheckFormsCookie(httpContext));
    }
}