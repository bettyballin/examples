csharp
using System;
using System.Web.Mvc;

[Authorize] // You can also do [Authorize(Roles="MyRole,YourRole")], etc...
public class ApplicationLogController : Controller
{
    public ActionResult Index()
    {
        return View();
    }
}

class Program
{
    static void Main()
    {
        var controller = new ApplicationLogController();
        var result = controller.Index() as ViewResult;
        Console.WriteLine(result.ViewName);
    }
}