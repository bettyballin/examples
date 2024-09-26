csharp
using System;
using System.Web;

public class Global : HttpApplication
{
    protected void Application_Error(object sender, EventArgs e)
    {
        var er = HttpContext.Current.Error;
        if (er.GetType().Equals(typeof(System.Security.SecurityException)))
        {
            HttpContext.Current.Response.Redirect(FormsAuthentication.LoginUrl + "?ReturnUrl=" + HttpContext.Current.Request.Path);
        }
    }
}