csharp
using System;
using System.Web.Security;

public partial class Login : System.Web.UI.Page
{
    protected void btnLogin_Click(object sender, EventArgs e)
    {
        if (Membership.ValidateUser(txtUserName.Text, txtPassword.Text))
        {
            FormsAuthentication.RedirectFromLoginPage(txtUserName.Text, false);
        }
        else
        {
            lblError.Text = "Invalid Username or Password";
        }
    }
}