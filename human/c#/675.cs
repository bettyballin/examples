csharp
using System;
using System.Web;

public partial class YourPage : System.Web.UI.Page
{
    protected void ClosePopUp(string objBhID)
    {
        string pageName = Request.Url.AbsolutePath;
        var modalPopupBehavior = (AjaxControlToolkit.ModalPopupExtender)Page.FindControl(objBhID);
        if (modalPopupBehavior != null)
        {
            modalPopupBehavior.Hide();
        }
        if (objBhID == "bhThankMsg" && pageName == "/Projects/Comm.aspx")
        {
            var objPartnerID = Request.Form["myDynamicData_partnerId"];
            var id = Request.Form["myDynamicData_id"];
            if (!string.IsNullOrEmpty(objPartnerID))
            {
                Response.Redirect("/Projects/Comm.aspx?Id=" + HttpUtility.UrlEncode(id) + "&partnerid=" + HttpUtility.UrlEncode(objPartnerID));
            }
            else
            {
                Response.Redirect("/Projects/Comm.aspx?Id=" + HttpUtility.UrlEncode(id));
            }
        }
    }
}