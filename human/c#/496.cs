csharp
[Authorize(Roles = "Enabled")]
[Authorize(Roles = "Editor,Admin")]
public ActionResult Details(int id) 
{
    // Only available to users who are Enabled AND either an Admin OR an Editor
    return View();
}

Alternatively:

csharp
[Authorize(Roles = "Enabled, Editor, Admin")]
[Authorize(Roles = "Enabled")]
public ActionResult Details(int id) 
{
    // Only available to users who are Enabled AND either an Admin OR an Editor
    return View();
}

Alternatively with Policy:

csharp
services.AddAuthorization(options =>
{
    options.AddPolicy("EnabledAdminEditor", policy => policy.RequireRole("Enabled", "Admin", "Editor"));
});

[Authorize(Policy = "EnabledAdminEditor")]
public ActionResult Details(int id) 
{
    // Only available to users who are Enabled AND either an Admin OR an Editor
    return View();
}