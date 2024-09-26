csharp
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Microsoft.Practices.Unity;

public static class SecurityConfig
{
    public static void Configure()
    {
        SecurityConfigurator.Configure(c =>
        {
            c.GetAuthenticationStatusFrom(() => HttpContext.Current.User.Identity.IsAuthenticated);
            c.GetRolesFrom(() => (HttpContext.Current.Session["Roles"] as string[]));
            // Blanked Deny All
            c.ForAllControllers().DenyAnonymousAccess();

            // Publicly Accessible Areas
            c.For<LoginController>().Ignore();

            // This is the part for finding all of the classes that inherit
            // from IPolicyViolationHandler so you don't have to use an IOC
            // Container.
            c.ResolveServicesUsing(type =>
            {
                if (type == typeof(IPolicyViolationHandler))
                {
                    var types = Assembly
                        .GetAssembly(typeof(MvcApplication))
                        .GetTypes()
                        .Where(x => typeof(IPolicyViolationHandler).IsAssignableFrom(x)).ToList();

                    var handlers = types.Select(t => Activator.CreateInstance(t) as IPolicyViolationHandler).ToList();

                    return handlers.OfType<object>();
                }
                return Enumerable.Empty<object>();
            });
        });
    }
}

public class MvcApplication : System.Web.HttpApplication
{
    protected void Application_Start()
    {
        SecurityConfig.Configure();
    }
}

public class LoginController : Controller
{
    // Your login controller implementation
}

public interface IPolicyViolationHandler
{
    // Your policy violation handler interface
}

public class SecurityConfigurator
{
    public static void Configure(Action<SecurityConfiguration> configuration)
    {
        var config = new SecurityConfiguration();
        configuration(config);
    }
}

public class SecurityConfiguration
{
    public void GetAuthenticationStatusFrom(Func<bool> isAuthenticated)
    {
        // Your authentication status implementation
    }

    public void GetRolesFrom(Func<string[]> getRoles)
    {
        // Your roles implementation
    }

    public void ForAllControllers()
    {
        // Your for all controllers implementation
    }

    public void DenyAnonymousAccess()
    {
        // Your deny anonymous access implementation
    }

    public void For<TController>()
    {
        // Your for controller implementation
    }

    public void Ignore()
    {
        // Your ignore implementation
    }

    public void ResolveServicesUsing(Func<Type, IEnumerable<object>> resolve)
    {
        // Your resolve services implementation
    }
}