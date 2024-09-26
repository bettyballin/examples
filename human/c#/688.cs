csharp
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using System;

public class AwesomeAuthenticationMiddleware : AuthenticationMiddleware<AwesomeAuthenticationOptions>
{
    public AwesomeAuthenticationMiddleware(RequestDelegate next, 
        IOptions<AwesomeAuthenticationOptions> options,
        ILoggerFactory loggerFactory,
        UrlEncoder urlEncoder) : base(next, options, loggerFactory, urlEncoder) {

    }

    protected override AuthenticationHandler<AwesomeAuthenticationOptions> CreateHandler()
    {
        return new AwesomeAuthentication();
    }
}

public class AwesomeAuthentication : AuthenticationHandler<AwesomeAuthenticationOptions>
{
    protected override async Task<AuthenticateResult> HandleAuthenticateAsync()
    {
        // Your authentication logic here
        throw new NotImplementedException();
    }
}

public class AwesomeAuthenticationOptions : AuthenticationSchemeOptions
{
}

public class Startup
{
    public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
    {
        app.UseRouting();

        app.UseAuthentication();

        app.UseEndpoints(endpoints =>
        {
            endpoints.MapControllers();
        });
    }

    public void ConfigureServices(IServiceCollection services)
    {
        services.AddAuthentication(options =>
        {
            options.DefaultScheme = "Awesome";
        })
        .AddScheme<AwesomeAuthenticationOptions, AwesomeAuthenticationMiddleware>("Awesome", null);

        services.AddControllers();
    }
}

class Program
{
    static void Main(string[] args)
    {
        CreateHostBuilder(args).Build().Run();
    }

    static IHostBuilder CreateHostBuilder(string[] args) =>
        Host.CreateDefaultBuilder(args)
            .ConfigureWebHostDefaults(webBuilder =>
            {
                webBuilder.UseStartup<Startup>();
            });
}