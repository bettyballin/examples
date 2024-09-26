csharp
using System;
using System.Web;
using System.Web.Services;

[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
public class Service : System.Web.Services.WebService
{
    private string allowedAddress = "192.168.1.100"; // replace with your allowed address

    [WebMethod]
    public bool IsAlive()
    {
        string callingAddress = HttpContext.Current.Request.UserHostAddress;
        return (callingAddress == allowedAddress);
    }
}