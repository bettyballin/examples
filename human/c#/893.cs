csharp
using System;
using System.Web.Mvc;
using System.Web.Security;

public class RolesController : Controller
{
    public ActionResult Index()
    {
        ViewBag.RoleId = Roles.GetAllRoles().Select(r => new SelectListItem { Text = r, Value = r });
        return View();
    }
}