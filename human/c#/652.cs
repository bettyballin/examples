csharp
using System;
using System.Web;

class Program
{
    static void Main()
    {
        var context = new HttpContext(new HttpRequest(null, "http://example.com", null), new HttpResponse(null));
        var user = new GenericPrincipal(new GenericIdentity("username"), new string[] { });
        context.User = user;

        context.Application.Lock();
        context.Application[user.Identity.Name] = true;
        context.Application.UnLock();
    }
}