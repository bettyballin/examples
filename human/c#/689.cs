csharp
using Microsoft.AspNetCore.Builder;

public class Startup
{
    public void Configure(IApplicationBuilder app)
    {
        app.UseMiddleware<AwesomeAuthenticationMiddleware>();
    }
}