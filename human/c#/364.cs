csharp
using System;
using System.Web.Mvc;

public class UserController : BaseAuthorizedUserController
{
    [ExceptionPolicy]
    public UserController() { }

    public ActionResult Index()
    {
        return View();
    }
}

public class BaseAuthorizedUserController : Controller
{
    // Implementation of BaseAuthorizedUserController
}

[AttributeUsage(AttributeTargets.Class, AllowMultiple = false, Inherited = true)]
public class ExceptionPolicyAttribute : AuthorizeAttribute
{
    // Implementation of ExceptionPolicyAttribute
}