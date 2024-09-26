using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Http;
using System;
using System.Threading.Tasks;

public class Startup
{
    public void ConfigureServices(IServiceCollection services)
    {
        services.AddAuthentication(options =>
        {
            options.Events.OnRedirectToIdentityProvider = redirectContext =>
            {
                if (redirectContext.Request.Path.StartsWithSegments("/api"))
                {
                    if (redirectContext.Response.StatusCode == (int)HttpStatusCode.OK)
                    {
                        redirectContext.ProtocolMessage.State = options.StateDataFormat.Protect(redirectContext.Properties);
                        redirectContext.Response.StatusCode = (int)HttpStatusCode.Unauthorized;
                        redirectContext.Response.Headers["Location"] = redirectContext.ProtocolMessage.CreateAuthenticationRequestUrl();
                    }
                    redirectContext.HandleResponse();
                }
                return Task.CompletedTask;
            };
        });
    }

    public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
    {
        app.UseRouting();
        app.UseAuthentication();
        app.UseEndpoints(endpoints =>
        {
            endpoints.MapControllers();
        });
    }
}