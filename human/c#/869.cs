csharp
using System.Web.Mvc;

public class MyController : Controller
{
    [HttpGet]
    public ActionResult MyAction(MyModel model)
    {
        ModelState.Remove("SSN");
        model.SSN = null;
        return View(model);
    }
}

public class MyModel
{
    public string SSN { get; set; }
}