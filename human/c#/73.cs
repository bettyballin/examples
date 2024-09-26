csharp
using System;
using System.Web.UI;

public partial class WebForm1 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (Page != null && Page.EnableEventValidation)
        {
            Form.Attributes["onsubmit"] = "return AllowFormToRun();";
        }
    }
}

<script language="javascript" type="text/javascript">
    function AllowFormToRun()
    {
        var MyEventValidation = $("#__EVENTVALIDATION");

        if(MyEventValidation.length == 0 || MyEventValidation.val() == ""){
            alert("Please wait for the page to fully loaded.");
            return false;
        }

        return true; 
    }       
</script>