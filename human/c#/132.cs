csharp
using System;
using System.Web;
using System.Web.Security;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (User.Identity.IsAuthenticated)
        {
            if (IsValidUserCredentials())
            {
                var returnUrl = Request.QueryString["ReturnUrl"];
                Response.Redirect(returnUrl ?? "default.aspx");
            }
        }
        else
        {
            DisplayLoginForm();
        }
    }

    private bool IsValidUserCredentials()
    {
        // Implement your logic to validate user credentials here
        // For demonstration purposes, it always returns true
        return true;
    }

    private void DisplayLoginForm()
    {
        // Implement your logic to display the login form here
        // For demonstration purposes, it simply redirects to a login page
        Response.Redirect("login.aspx");
    }
}