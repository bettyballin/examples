csharp
using System.Web.Mvc;
using Microsoft.Owin.Security;

public class AccountController : Controller
{
    public ActionResult LogOut()
    {
        Request.GetOwinContext().Authentication.SignOut("ApplicationCookie");

        return RedirectToAction("Login");
    }

    public ActionResult Login()
    {
        return View();
    }
}