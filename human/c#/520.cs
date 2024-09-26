csharp
using System;
using System.Web;
using System.Web.Mvc;

[AttributeUsageAttribute(AttributeTargets.Class | AttributeTargets.Method,
    Inherited = true, AllowMultiple = true)]
public class CustomAuthorizeAttribute : AuthorizeAttribute
{
    private string _url; 
    private Operations _operation; 

    public enum Operations
    {
        Create,
        Read,
        Update,
        Delete
    }

    public CustomAuthorizeAttribute(string url, Operations operation)
    {
        _url = url;
        _operation = operation;
    }

    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        // any httpContext.Request... operations
        return base.AuthorizeCore(httpContext);
    }
}

public class HomeController : Controller
{
    [CustomAuthorize("Home/Index", CustomAuthorizeAttribute.Operations.Read)]
    public ActionResult Index()
    {
        return View();
    }
}

public class MvcApplication : HttpApplication
{
    protected void Application_Start()
    {
        AreaRegistration.RegisterAllAreas();
        FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
        RouteConfig.RegisterRoutes(RouteTable.Routes);
    }
}