csharp
using System;
using System.Web.Mvc;

[Authorize(Roles = "Admin")]
public class EditController : Controller
{
    public ActionResult Index()
    {
        return View();
    }
}