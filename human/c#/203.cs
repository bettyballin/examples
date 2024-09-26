csharp
using System;
using System.Web;
using System.Web.Mvc;

public class MvcApplication : System.Web.HttpApplication
{
    public static void RegisterGlobalFilters(GlobalFilterCollection filters)
    {
        filters.Add(new HandleErrorAttribute());
    }

    protected void Application_Start()
    {
        RegisterGlobalFilters(GlobalFilters.Filters);
    }
}

class Program
{
    static void Main(string[] args)
    {
        var application = new MvcApplication();
        application.Init();
    }
}