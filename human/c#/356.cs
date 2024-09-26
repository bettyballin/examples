csharp
using System;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Controllers;

public class PasswordAuthorizeAttribute : AuthorizeAttribute
{
    public override void OnAuthorization(HttpActionContext actionContext)
    {
        try
        {
            string password = actionContext.Request.Headers.GetValues("Password").First();

            // instead of hard coding the password you can store it in a config file, database, etc.
            if (password != "abc123")
            {
                // password is not correct, return 401 (Unauthorized)
                actionContext.Response = new HttpResponseMessage(HttpStatusCode.Unauthorized);
                return;
            }
        }
        catch (Exception e)
        {
            // if any errors occur, or the Password Header is not present we cannot trust the user
            // log the error and return 401 again
            actionContext.Response = new HttpResponseMessage(HttpStatusCode.Unauthorized);
            return;
        }
    }
}

[PasswordAuthorize]
public class YourController : ApiController
{
    public IHttpActionResult Get()
    {
        return Ok("Authorized");
    }
}

class Program
{
    static void Main(string[] args)
    {
        var config = new HttpConfiguration();
        config.MapHttpAttributeRoutes();
        config.Routes.MapHttpRoute("DefaultApi", "api/{controller}/{id}", new { id = RouteParameter.Optional });

        using (var server = new HttpServer(config))
        {
            var client = new HttpClient(server);

            // Unauthorized request
            var request = new HttpRequestMessage(HttpMethod.Get, "http://localhost/api/Your");
            var response = client.SendAsync(request).Result;
            Console.WriteLine(response.StatusCode);

            // Authorized request
            request = new HttpRequestMessage(HttpMethod.Get, "http://localhost/api/Your");
            request.Headers.Add("Password", "abc123");
            response = client.SendAsync(request).Result;
            Console.WriteLine(response.StatusCode);
        }
    }
}