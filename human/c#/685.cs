Here's the executable code:

csharp
using System;
using System.Security.Claims;
using System.Web;
using System.Web.Mvc;
using Microsoft.Owin.Security;

public interface IUserSession
{
    string Username { get; }
    string BearerToken { get; }
}

public class UserSession : IUserSession
{
    public string Username
    {
        get { return ((ClaimsPrincipal)HttpContext.Current.User).FindFirst(ClaimTypes.Name).Value; }
    }

    public string BearerToken
    {
        get { return ((ClaimsPrincipal)HttpContext.Current.User).FindFirst("AccessToken").Value; }
    }
}

[Authorize]
public class HomeController : Controller
{
    private readonly IUserSession _userSession;

    public HomeController()
    {
        _userSession = new UserSession();
    }

    public HomeController(IUserSession userSession)
    {
        _userSession = userSession;
    }

    public ActionResult Index()
    {
        ViewBag.EmailAddress = _userSession.Username;
        ViewBag.AccessToken = _userSession.BearerToken;

        return View();
    }
}

public class Startup
{
    public void Configuration(IAppBuilder app)
    {
        ConfigureOAuth(app);
        app.UseWebApi(GlobalConfiguration.Configuration);
    }

    public void ConfigureOAuth(IAppBuilder app)
    {
        app.UseOAuthBearerAuthentication(new OAuthBearerAuthenticationOptions
        {
            AccessTokenFormat = new TicketDataFormat(new MachineKeyProtector()),
        });
    }
}

public class MachineKeyProtector : IDataProtector
{
    private readonly string[] _purposes;

    public MachineKeyProtector(params string[] purposes)
    {
        _purposes = purposes;
    }

    public byte[] Protect(byte[] data)
    {
        return MachineKey.Protect(data, _purposes);
    }

    public byte[] Unprotect(byte[] data)
    {
        return MachineKey.Unprotect(data, _purposes);
    }
}

public class FilterConfig
{
    public static void RegisterGlobalFilters(GlobalFilterCollection filters)
    {
        filters.Add(new HandleErrorAttribute());
    }
}

public class RouteConfig
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

public class MvcApplication : System.Web.HttpApplication
{
    protected void Application_Start()
    {
        AreaRegistration.RegisterAllAreas();
        FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
        RouteConfig.RegisterRoutes(RouteTable.Routes);
    }
}


html
<!-- Index.cshtml -->
@{
    ViewBag.Title = "Home Page";
}

<div class="jumbotron">
    <h1>Email Address</h1>
    <p class="lead">@ViewBag.EmailAddress</p>
    <h1>Access Token</h1>
    <p class="lead">@ViewBag.AccessToken</p>
</div>