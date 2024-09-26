csharp
using Microsoft.AspNetCore.Authentication;
using System.Security.Claims;
using System.Threading.Tasks;

public class AwesomeAuthentication : AuthenticationHandler<AwesomeAuthenticationOptions>
{
    protected override async Task<AuthenticateResult> HandleAuthenticateAsync()
    {
        var prop = new AuthenticationProperties();
        var identity = new ClaimsIdentity("AwesomeAuthentication");
        var principal = new ClaimsPrincipal(identity);
        var ticket = new AuthenticationTicket(principal, prop, "AwesomeAuthentication");
        return AuthenticateResult.Success(ticket);
    }
}

public class AwesomeAuthenticationOptions : AuthenticationSchemeOptions
{
    public override void Validate()
    {
        // validation logic
    }
}

public class Startup
{
    public void ConfigureServices(IServiceCollection services)
    {
        services.AddAuthentication(options =>
        {
            options.DefaultScheme = "AwesomeAuthentication";
        })
        .AddScheme<AwesomeAuthenticationOptions, AwesomeAuthentication>("AwesomeAuthentication", null);
    }

    public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
    {
        app.UseAuthentication();
        app.UseEndpoints(endpoints =>
        {
            endpoints.Map("/", async context =>
            {
                await context.Response.WriteAsync("Hello World!");
            });
        });
    }
}