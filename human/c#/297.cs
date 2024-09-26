csharp
using System.Web.Mvc;

[MyAuthorize]
public ActionResult Edit(Submission model)
{
    // Carry out method
    return View(model);
}

public class MyAuthorizeAttribute : AuthorizeAttribute
{
    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        // Your custom authorization logic here
        return true; // or return false;
    }
}

public class Submission
{
    // Your properties here
    public int Id { get; set; }
    public string Name { get; set; }
}

public class MyController : Controller
{
    [MyAuthorize]
    public ActionResult Edit(Submission model)
    {
        // Carry out method
        return View(model);
    }
}