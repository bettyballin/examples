csharp
using System;
using System.Web.Mvc;
using System.Web;

public class ContentSecurityPolicyFilterAttribute : ActionFilterAttribute
{
    public override void OnActionExecuting(ActionExecutingContext filterContext)
    {
        if (!filterContext.RequestContext.HttpContext.Items.Contains(nameof(ContentSecurityPolicyFilterAttribute)))
        {
            HttpResponseBase response = filterContext.HttpContext.Response;

            response.AddHeader("Content-Security-Policy", "default-src *; img-src * data:; ");
            filterContext.RequestContext.HttpContext.Items.Add(nameof(ContentSecurityPolicyFilterAttribute), string.Empty);
        }
        base.OnActionExecuting(filterContext);
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Example usage:
        var controller = new ExampleController();
        var filter = new ContentSecurityPolicyFilterAttribute();
        var filterContext = new ActionExecutingContext(
            new ControllerContext(new HttpContextWrapper(new HttpContext(new HttpRequest(null, "http://example.com", null))), controller),
            new ActionDescriptor(),
            new object[] { }
        );
        filter.OnActionExecuting(filterContext);
    }
}

public class ExampleController : Controller { }