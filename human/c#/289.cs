csharp
using System.Web.Mvc;

public class MyController : Controller
{
    public ActionResult MyAction(MyViewModel vm)
    {
        if (User.IsInRole("MyDeleteRole"))
        {
            return View("MyDeleteView", vm);
        }
        else
        {
            return View("NoDeleteView", vm);
        }
    }
}