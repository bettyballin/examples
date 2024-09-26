csharp
using System.Web.Http;
using System.Web.Routing;

protected void Application_Start()
{
    GlobalConfiguration.Configure(WebApiConfig.Register);
    RouteConfig.RegisterRoutes(RouteTable.Routes);
}