csharp
using System;
using System.Web.Mvc;

// Define the custom filter attribute
public class ManagerIdAuthenticationAttribute : AuthorizeAttribute
{
    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        // Your custom authorization logic goes here
        // For example:
        var managerId = httpContext.Request.QueryString["ManagerId"];
        if (managerId == "123") // Replace with your actual logic
        {
            return true;
        }
        return false;
    }
}

public class MyController : Controller
{
    [ManagerIdAuthentication]
    public ActionResult Details(int id)
    {
        // Gets executed if the filter allows it to go through.
        return View();
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Create an instance of the controller
        var controller = new MyController();

        // Call the Details action method
        var result = controller.Details(1);

        // Print the result
        Console.WriteLine(result);
    }
}