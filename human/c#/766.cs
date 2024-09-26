csharp
using System.Web;
using System.Web.Mvc;

// Truncated CSP filter
public class ContentSecurityPolicyFilterAttribute : ActionFilterAttribute
{
    public override void OnActionExecuting(ActionExecutingContext filterContext)
    {
        HttpResponseBase response = filterContext.HttpContext.Response;

        response.AddHeader("Content-Security-Policy", "default-src *; img-src * data:; ");

        base.OnActionExecuting(filterContext);
    }
}

// Addition to FilterConfig.cs
public class FilterConfig
{
    public static void RegisterGlobalFilters(GlobalFilterCollection filters)
    {
        filters.Add(new ContentSecurityPolicyFilterAttribute());
    }
}

// Example usage in Global.asax.cs
public class MvcApplication : System.Web.HttpApplication
{
    protected void Application_Start()
    {
        FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
    }
}