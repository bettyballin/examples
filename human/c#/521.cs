csharp
using System.Web.Security;
using System.Web;

class Program
{
    static void Main()
    {
        var currentUser = Membership.GetUser(HttpContext.Current.User.Identity.Name);
    }
}