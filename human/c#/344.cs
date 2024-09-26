csharp
using System;
using System.Web.Mvc;
using FluentSecurity;

public class DenyAnonymousAccessPolicyViolationHandler : IPolicyViolationHandler
{
    public ActionResult Handle(PolicyViolationException exception)
    {
        var controllerContext = new ControllerContext();
        var flash = new Flash(controllerContext);
        flash.Error("You must first login to access that page");
        return new RedirectResult("/");
    }
}

public class Flash
{
    private readonly ControllerContext _controllerContext;

    public Flash(ControllerContext controllerContext)
    {
        _controllerContext = controllerContext;
    }

    public void Error(string message)
    {
        _controllerContext.Controller.TempData["Error"] = message;
    }
}