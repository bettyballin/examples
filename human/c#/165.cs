csharp
using System;
using System.Web;

public partial class ErrorHandling : System.Web.HttpApplication
{
    protected void Application_Error(object sender, EventArgs e)
    {
        //Exception ex = Server.GetLastError();

        Server.Transfer("~/DefaultErrorPage.aspx");
    }
}