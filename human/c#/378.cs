csharp
using System;
using System.Web;

public class HttpsRedirect
{
    public void RedirectToHttps(HttpRequest Request, HttpResponse Response)
    {
        if (!Request.IsSecureConnection)
        {
            string redirectUrl = Request.Url.ToString().Replace("http:", "https:");
            Response.Redirect(redirectUrl, true);
        }
    }
}