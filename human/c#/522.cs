csharp
using System;
using System.Data.Entity;
using System.Web.Mvc;

public class YourController : Controller
{
    private YourDbContext udb = new YourDbContext();

    public ActionResult YourAction(YourModel model)
    {
        UserProfile user = udb.UserProfiles.Where(m => m.UserName == model.UserName).FirstOrDefault();
        var userType = user.UserType; // this brings your UserType from database

        // then you can use this as
        TempData["UserType"] = userType;

        return RedirectToAction("YourNextAction");
    }
}

public class YourDbContext : DbContext
{
    public DbSet<UserProfile> UserProfiles { get; set; }
}

public class YourModel
{
    public string UserName { get; set; }
}

public class UserProfile
{
    public string UserName { get; set; }
    public string UserType { get; set; }
}