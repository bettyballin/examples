csharp
using System;
using System.Web;

class Program
{
    static void Main()
    {
        var txtEmail = new System.Web.UI.WebControls.TextBox { Text = "user@example.com" };
        var response = new HttpResponse(new StringWriter());
        response.Cookies.Add(new HttpCookie("UserInfo"));
        response.Cookies["UserInfo"]["userName"] = txtEmail.Text;
        Console.WriteLine(response.Cookies["UserInfo"]["userName"]);
    }
}