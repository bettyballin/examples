csharp
using System;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

public class DenyAnonymousAccessPolicyViolationHandler : IPolicyViolationHandler
{
    public ActionResult Handle(PolicyViolationException exception)
    {
        var routeData = RouteTable.Routes.GetRouteData(new HttpContextWrapper(HttpContext.Current));
        var areaName = routeData.GetAreaName();
        return
            new RedirectToRouteResult(
                new RouteValueDictionary(new { action = "AnonymousError", controller = "Error", area = areaName }));
    }
}

public interface IPolicyViolationHandler
{
    ActionResult Handle(PolicyViolationException exception);
}

public class PolicyViolationException : Exception
{
}

public class Program
{
    public static void Main()
    {
        var handler = new DenyAnonymousAccessPolicyViolationHandler();
        var exception = new PolicyViolationException();
        var result = handler.Handle(exception);
        Console.WriteLine(result);
    }
}