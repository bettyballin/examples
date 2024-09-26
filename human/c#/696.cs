csharp
using System.Web.Http;

public class ValueController : ApiController
{
    [JwtAuthentication]
    public string Get()
    {
        return "value";
    }
}

class Program
{
    static void Main()
    {
        var config = new HttpConfiguration();
        config.MapHttpAttributeRoutes();
        config.Routes.MapHttpRoute(
            name: "DefaultApi",
            routeTemplate: "api/{controller}/{id}",
            defaults: new { id = RouteParameter.Optional }
        );

        using (var server = new HttpServer(config))
        {
            var client = new HttpClient(server);
            var response = client.GetAsync("http://localhost/api/Value").Result;
            Console.WriteLine(response.Content.ReadAsStringAsync().Result);
        }
    }
}