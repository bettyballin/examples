csharp
using System;
using System.Collections.Generic;
using System.Web.Mvc;
using YourApplication.Models; // Assuming MenuItem is in this namespace

public class YourController : Controller
{
    protected override void OnActionExecuted(ActionExecutedContext filterContext)
    {
        // build list of menu items based on user's permissions, and add it to ViewData
        IEnumerable<MenuItem> menu = BuildMenu();
        ViewData["Menu"] = menu;
    }

    private IEnumerable<MenuItem> BuildMenu()
    {
        // Your implementation to build menu items based on user's permissions
        // For demonstration purposes, I'm returning an empty list
        return new List<MenuItem>();
    }
}

public class MenuItem
{
    // Your implementation of MenuItem class
}