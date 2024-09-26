csharp
using System.Web.Http;
using System.Web.Http.Authorize;

public class WebApiConfig
{
    public static void Register(HttpConfiguration config)
    {
        // Enable Web API routes
        config.MapHttpAttributeRoutes();

        // Register authorization filter globally
        config.Filters.Add(new AuthorizeAttribute());
    }
}

class Program
{
    static void Main(string[] args)
    {
        HttpConfiguration config = new HttpConfiguration();
        WebApiConfig.Register(config);

        using (var server = new HttpServer(config))
        {
            var client = new HttpClient(server);

            // You can test your API here...
        }
    }
}