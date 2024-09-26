csharp
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;

class Program
{
    static void Main(string[] args)
    {
        WebHost.CreateDefaultBuilder(args)
               .UseKestrel(c => c.AddServerHeader = false)
               .UseStartup<Startup>()
               .Build()
               .Run();
    }
}