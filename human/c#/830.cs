csharp
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Authorize;

// Require authorization for all actions on the controller.
[Authorize]
public class ValuesController : ApiController
{
    public HttpResponseMessage Get(int id)
    {
        return Request.CreateResponse(HttpStatusCode.OK, $"Received GET request with id {id}");
    }

    public HttpResponseMessage Post()
    {
        return Request.CreateResponse(HttpStatusCode.OK, "Received POST request");
    }
}