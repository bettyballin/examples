csharp
using System;
using System.Web;
using System.Security.Principal;

public class Authentication
{
    public void IsValidUser(HttpContext context)
    {
        if (context.User.Identity.Name != string.Empty)
        {
            if (!context.User.Identity.IsAuthenticated)
            {
                context.Response.Redirect("~/login.aspx");
            }
        }
        else
        {
            context.Response.Redirect("~/login.aspx");
        }
    }
}