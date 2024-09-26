csharp
using System;
using System.Security.Principal;
using System.Web.UI;

public partial class Page : System.Web.UI.Page
{
    protected void Page_Init(object sender, EventArgs e)
    {
        if (User.Identity.IsAuthenticated)
            ViewStateUserKey = User.Identity.Name;
    }
}