csharp
using System;
using System.Web.Security;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // Assuming DropDownList1 and txtAnswer are controls on the page
    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        string userName = "YourUserName"; // Replace with actual username
        MembershipUser user = Membership.GetUser(userName);
        if (user != null)
        {
            string password = user.ResetPassword();
            string sQuestion = DropDownList1.SelectedValue.ToString();
            string sAnswer = txtAnswer.Text.ToString();
            user.ChangePasswordQuestionAndAnswer(password, sQuestion, sAnswer);
        }
        else
        {
            // Handle user not found scenario
        }
    }
}