csharp
using System;
using System.Web.Mvc;
using System.Data.Entity;

public class MyController : Controller
{
    private MyDbContext db = new MyDbContext();

    [Authorize, ValidateAntiForgeryToken]
    [HttpPost]
    public ActionResult NukeMyBankAccount(int accountId)
    {
        var account = db.GetAccount(accountId);

        // validate
        if (CurrentUser.Id != account.Owner.Id)
        {
            return RedirectToAction("Unauthorized");
        }
        else
        {
            db.NukeAccount(accountId, areYouSure: true);
        }

        return RedirectToAction("AccountNuked");
    }
}

public class MyDbContext : DbContext
{
    public Account GetAccount(int accountId)
    {
        // Implementation to get account from database
        throw new NotImplementedException();
    }

    public void NukeAccount(int accountId, bool areYouSure)
    {
        // Implementation to nuke account from database
        throw new NotImplementedException();
    }
}

public class Account
{
    public int Id { get; set; }
    public Owner Owner { get; set; }
}

public class Owner
{
    public int Id { get; set; }
}

public class CurrentUser
{
    public static int Id { get; set; }
}

public class MvcApplication : System.Web.HttpApplication
{
    protected void Application_Start()
    {
        AreaRegistration.RegisterAllAreas();
        FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
        RouteConfig.RegisterRoutes(RouteTable.Routes);
        BundleConfig.RegisterBundles(BundleTable.Bundles);
    }
}