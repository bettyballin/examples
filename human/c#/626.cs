csharp
using System.Web.Http;

public static class WebApiConfig
{
    public static void Register(HttpConfiguration config)
    {
        config.Routes.MapHttpRoute(
            name: "DefaultApi",
            routeTemplate: "api/{controller}/{id}",
            defaults: new { id = RouteParameter.Optional }
        );
    }
}

class Program
{
    static void Main(string[] args)
    {
        var config = new HttpConfiguration();
        WebApiConfig.Register(config);
        using (var server = new HttpServer(config))
        {
            server.ListenAsAHttpListener();
        }
    }
}

public static class HttpServerExtensions
{
    public static void ListenAsAHttpListener(this HttpServer server)
    {
        var listener = (HttpListener)server.Properties["System.Net.HttpListener"];
        if (listener == null)
        {
            listener = new HttpListener();
            server.Properties["System.Net.HttpListener"] = listener;
        }
        listener.Start();
        Console.WriteLine("Server is running. Press Enter to exit.");
        Console.ReadLine();
        listener.Stop();
    }
}