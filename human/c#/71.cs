csharp
using System;
using System.Diagnostics;
using System.Web;

public abstract class BasePage : System.Web.UI.Page
{
    protected override object LoadPageStateFromPersistenceMedium()
    {
        try
        {
            return base.LoadPageStateFromPersistenceMedium();            
        }
        catch (Exception x)
        {
            string vsString = Request.Form["__VIEWSTATE"];
            string cThePage = Request.RawUrl;

            // Log the error
            Debug.WriteLine("Error loading view state: " + x.ToString());
            Debug.WriteLine("ViewState: " + vsString);
            Debug.WriteLine("IP: " + Request.UserHostAddress);
            Debug.WriteLine("Page: " + cThePage);

            // Check for local errors
            Debug.Fail("Fail to load view state ! Reason:" + x.ToString());
        }

        // If we reach here, then loading the view state has failed, so we reload the page
        Response.Redirect(Request.RawUrl, true);        

        // The return is not used after the redirect
        return string.Empty;
    }    
}