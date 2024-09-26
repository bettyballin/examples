csharp
using System;
using System.Web.Mvc;

public class MenuItem
{
    // Properties of MenuItem class
}

public class MenuController : Controller
{
    public ActionResult Index()
    {
        var menu = new MenuItem[] { /* Initialize menu items */ };
        ViewData["Menu"] = menu;
        return View();
    }
}

// In Index.cshtml
@{
    var model = ViewData["Menu"] as IEnumerable<MenuItem>;
    Html.RenderPartial("Menu", model);
}