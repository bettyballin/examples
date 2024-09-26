csharp
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Security.Claims;
using System.Threading.Tasks;

public class DevelopmentUserMiddleware
{
    private readonly RequestDelegate _next;

    public DevelopmentUserMiddleware(RequestDelegate next)
    {
        _next = next;
    }

    public async Task InvokeAsync(HttpContext context)
    {
        string token = context.Request.Headers["Authorization"];
        if (!string.IsNullOrEmpty(token))
        {
            List<Claim> claims = context.User.Claims.ToList();
            claims.Remove(claims.Find(x => x.Type == ClaimTypes.NameIdentifier));
            claims.Add(new Claim(ClaimTypes.NameIdentifier, "75cc7127-a31c-418b-b580-27379136b148"));
            claims.Remove(claims.Find(x => x.Type == ClaimTypes.Name));
            claims.Add(new Claim(ClaimTypes.Name, "Name Surname"));
            var userIdentity = new ClaimsIdentity(claims, "Identity");
            context.User = new ClaimsPrincipal(userIdentity);
        }
        await _next(context);
    }
}