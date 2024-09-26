csharp
using System;
using System.Web;
using System.Web.Mvc;

public class CustomAuthorizeAttribute : AuthorizeAttribute
{
    protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
    {
        if (filterContext.HttpContext.User.Identity.IsAuthenticated)
            throw new HttpException((int)HttpStatusCode.Forbidden, "Unauthorized access");

        base.HandleUnauthorizedRequest(filterContext);
    }
}

class Program
{
    static void Main(string[] args)
    {
        var httpContext = new HttpContextWrapper(new HttpContext(new HttpRequest("", "http://localhost", ""), new HttpResponse(null)));
        var controllerContext = new ControllerContext(new RequestContext(httpContext, new RouteData()), new DummyController());
        var filterContext = new AuthorizationContext(controllerContext);

        var attribute = new CustomAuthorizeAttribute();
        attribute.OnAuthorization(filterContext);
        attribute.HandleUnauthorizedRequest(filterContext);
    }
}

class DummyController : Controller { }