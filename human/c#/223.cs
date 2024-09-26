csharp
using System.Web.Security;

public class AuthenticationChecker
{
    public bool IsAuthenticationTicketValid(string formsCookieValue)
    {
        var authenticationTicket = FormsAuthentication.Decrypt(formsCookieValue);
        if (authenticationTicket.Expired)
            return false;
        return true;
    }
}