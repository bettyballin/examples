csharp
using System;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

public class MyAuthorizeAttribute : AuthorizeAttribute
{
    protected override bool AuthorizeCore(HttpContextBase httpContext)
    {
        var authorized = base.AuthorizeCore(httpContext);
        if (!authorized)
        {
            return false;
        }

        var rd = httpContext.Request.RequestContext.RouteData;

        var id = rd.Values["id"];
        var userName = httpContext.User.Identity.Name;

        var unit = new UnitOfWork(); // Assuming you have a UnitOfWork class

        Submission submission = unit.SubmissionRepository.GetByID(id.ToString());
        User user = unit.UserRepository.GetByUsername(userName);

        return submission.UserID == user.UserID;
    }
}

public class UnitOfWork
{
    public SubmissionRepository SubmissionRepository { get; set; }
    public UserRepository UserRepository { get; set; }

    public UnitOfWork()
    {
        SubmissionRepository = new SubmissionRepository();
        UserRepository = new UserRepository();
    }
}

public class SubmissionRepository
{
    public Submission GetByID(string id)
    {
        // Your implementation to get a submission by ID
        return new Submission { UserID = 1 };
    }
}

public class UserRepository
{
    public User GetByUsername(string username)
    {
        // Your implementation to get a user by username
        return new User { UserID = 1 };
    }
}

public class Submission
{
    public int UserID { get; set; }
}

public class User
{
    public int UserID { get; set; }
}

class Program
{
    static void Main()
    {
        var httpContext = new HttpContext(new HttpRequest(null, "http://example.com", null), new HttpResponse(null));
        var controllerContext = new ControllerContext(new RequestContext(httpContext, new RouteData()), new MyController());
        var attribute = new MyAuthorizeAttribute();
        var authorized = attribute.AuthorizeCore(httpContext);
        Console.WriteLine(authorized);
    }
}

public class MyController : Controller
{
}