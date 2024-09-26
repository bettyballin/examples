csharp
using System.Web.Mvc;

public class HomeController : Controller
{
    public ActionResult PartialContentForHome()
    {
        return PartialView("PartialContentForHome");
    }
}