csharp
using System.Web.Mvc;

[Authorize]
public class AuthorizeController : Controller
{
}

public class HomeController : AuthorizeController
{
    public ActionResult Index()
    {
        return View();
    }
}

public class AccountController : Controller
{
    [AllowAnonymous]
    public ActionResult Login()
    {
        return View();
    }
}

public class MvcApplication : System.Web.HttpApplication
{
    protected void Application_Start()
    {
        AreaRegistration.RegisterAllAreas();
        RouteConfig.RegisterRoutes(RouteTable.Routes);
    }
}

public static class RouteConfig
{
    public static void RegisterRoutes(RouteCollection routes)
    {
        routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

        routes.MapRoute(
            name: "Default",
            template: "{controller}/{action}/{id}",
            defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
        );
    }
}