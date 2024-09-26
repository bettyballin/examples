csharp
using System.Web.Mvc;
using System.Web.Security;

namespace MyMvcApp.Controllers
{
    public class MyController : Controller
    {
        [Authorize(Roles = "Managers")]
        public ActionResult CompanySecrets()
        {
            return View();
        }

        [Authorize(Users="redmond\\swalther")]
        public ActionResult StephenSecrets()
        {
            return View();
        }
    }
}