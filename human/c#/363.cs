csharp
using System;
using System.Web.Mvc;
using System.Web.Security;

public class SecuredOperationAttribute : AuthorizeAttribute { }

public class ExceptionPolicyAttribute : HandleErrorAttribute { }

public class MyController : Controller
{
    [SecuredOperation]
    [ExceptionPolicy]
    public ActionResult Edit(int id)
    {
        return View();
    }
}

class Program
{
    static void Main()
    {
        try
        {
            var controller = new MyController();
            var result = controller.Edit(1);
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
    }
}