csharp
using System;
using System.Web.UI;

public partial class _Default : Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string message = Request.QueryString["message"];
        if (!string.IsNullOrEmpty(message))
            directlyDisplayedLiteral.Text = message;
    }
}