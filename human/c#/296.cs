csharp
using System.Web.Mvc;
using System.Web;

public class MyAuthorizeAttribute : AuthorizeAttribute
{
    private readonly IUnitOfWork unit;

    public MyAuthorizeAttribute(IUnitOfWork unit)
    {
        this.unit = unit;
    }

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

        Submission submission = unit.SubmissionRepository.GetByID((int)id);
        User user = unit.UserRepository.GetByUsername(userName);

        rd.Values["model"] = submission;

        return submission.UserID == user.UserID;
    }
}

public interface IUnitOfWork
{
    SubmissionRepository SubmissionRepository { get; }
    UserRepository UserRepository { get; }
}

public class SubmissionRepository
{
    public Submission GetByID(int id)
    {
        // implement get by id logic
    }
}

public class UserRepository
{
    public User GetByUsername(string username)
    {
        // implement get by username logic
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