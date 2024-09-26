csharp
using System.Net;
using System.Web.Http;
using System.Web.Http.Controllers;

public class ValuesController : ApiController
{
    public HttpResponseMessage Get()
    {
        return Request.CreateResponse(HttpStatusCode.OK, "Get Success");
    }

    // Require authorization for a specific action.
    [Authorize]
    public HttpResponseMessage Post()
    {
        return Request.CreateResponse(HttpStatusCode.OK, "Post Success");
    }
}

public class WebApiConfig
{
    public static void Register(HttpConfiguration config)
    {
        config.MapHttpAttributeRoutes();

        config.Routes.MapHttpRoute(
            name: "DefaultApi",
            routeTemplate: "api/{controller}/{id}",
            defaults: new { id = RouteParameter.Optional }
        );
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        var config = new HttpConfiguration();
        WebApiConfig.Register(config);

        using (var server = new HttpServer(config))
        {
            var client = new HttpClient(server);

            var response = client.GetAsync("http://localhost/api/values").Result;
            Console.WriteLine(response.Content.ReadAsStringAsync().Result);

            client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", "your_token");
            response = client.PostAsync("http://localhost/api/values", new StringContent("")).Result;
            Console.WriteLine(response.Content.ReadAsStringAsync().Result);
        }
    }
}