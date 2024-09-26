csharp
using System;
using System.Web.Security;

public partial class Login : System.Web.UI.Page
{
    protected void LoginButton_Click(object sender, EventArgs e)
    {
        if (Membership.ValidateUser(UsernameTextbox.Text, PasswordTextbox.Text))
            FormsAuthentication.RedirectFromLoginPage(UsernameTextbox.Text, NotPublicCheckBox.Checked);
        else
            Msg.Text = "Login failed. Please check your user name and password and try again.";
    }
}