csharp
using System;
using System.Web.Mvc;

public class CustomClaimsAuthorizeAttribute : AuthorizeAttribute
{
    private readonly string _parameter;

    public CustomClaimsAuthorizeAttribute(string parameter)
    {
        _parameter = parameter;
    }

    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        // Implement your custom authorization logic here
        // For example:
        var claimsIdentity = httpContext.User.Identity as ClaimsIdentity;
        if (claimsIdentity != null)
        {
            var claim = claimsIdentity.FindFirst(_parameter);
            if (claim != null)
            {
                return true;
            }
        }
        return false;
    }

    protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
    {
        filterContext.Result = new HttpUnauthorizedResult();
    }
}

public class MyController : Controller
{
    [CustomClaimsAuthorize("myParameter")]
    public ActionResult Index()
    {
        // Your action code here
        return View();
    }
}