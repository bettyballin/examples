csharp
using System.Web.Http;

public static class WebApiConfig
{
    public static void Register(HttpConfiguration config)
    {
        // Other Web API configuration code goes here

        // This is a globally registered attribute
        config.Filters.Add(new LocalRequestOnlyAttribute()); 
    }
}

public class LocalRequestOnlyAttribute : AuthorizeAttribute
{
    protected override bool IsAuthorized(HttpActionContext context)
    {
        return context.RequestContext.IsLocal;
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
            server.ListenAsAHttpServer("http://localhost:8000/");
            Console.WriteLine("Server is listening on http://localhost:8000/");
            Console.ReadLine();
        }
    }
}