csharp
using System;
using System.Web.Mvc;

public class MyAuthorizeAttribute : AuthorizeAttribute
{
    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        // Your custom authorization logic here
        return true;
    }
}

public class MyController : Controller
{
    [MyAuthorize]
    public ActionResult Edit(int id)
    {
        // Carry out method
        return View();
    }
}

class Program
{
    static void Main()
    {
        var controller = new MyController();
        var result = controller.Edit(1);
    }
}