csharp
using System.Web;

public class AuthenticationChecker
{
    public bool IsAuthenticated(HttpContext httpContext)
    {
        if (!httpContext.Request.IsAuthenticated)
            return false;
        return true;
    }
}

class Program
{
    static void Main()
    {
        AuthenticationChecker checker = new AuthenticationChecker();
        HttpContext context = HttpContext.Current;
        bool isAuthenticated = checker.IsAuthenticated(context);
        System.Console.WriteLine(isAuthenticated);
    }
}