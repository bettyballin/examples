csharp
using System;
using System.Web;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string message = Request.QueryString["message"];
        if (!string.IsNullOrEmpty(message))
            directlyDisplayedLiteral.Text = Server.HtmlEncode(message);
    }
}