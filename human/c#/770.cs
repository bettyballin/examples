csharp
using System;
using System.Web;
using System.Web.Mvc;

public class ContentSecurityPolicyFilterAttribute : ActionFilterAttribute
{
    public override void OnActionExecuting(ActionExecutingContext filterContext)
    {
        HttpResponseBase response = filterContext.HttpContext.Response;
        var header = response.Headers["Content-Security-Policy"];
        if (header == null)
        {
            response.AddHeader("Content-Security-Policy", "default-src *; img-src * data:; ");
        }
        base.OnActionExecuting(filterContext);
    }
}

public class HomeController : Controller
{
    [ContentSecurityPolicyFilter]
    public ActionResult Index()
    {
        return View();
    }
}

class Program
{
    static void Main()
    {
        // This is just an example of using the attribute with a controller.
        // In a real application, you would likely be using this attribute in an ASP.NET MVC application.
    }
}