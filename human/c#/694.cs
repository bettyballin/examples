csharp
using System;
using System.Web.Http;
using System.Security.Claims;
using System.IdentityModel.Tokens.Jwt;
using Microsoft.IdentityModel.Tokens;
using System.Text;

public class TokenController : ApiController
{
    // This is naive endpoint for demo, it should use Basic authentication
    // to provide token or POST request
    [AllowAnonymous]
    public IHttpActionResult Get(string username, string password)
    {
        if (CheckUser(username, password))
        {
            var token = JwtManager.GenerateToken(username);
            return Ok(token);
        }

        return Unauthorized();
    }

    public bool CheckUser(string username, string password)
    {
        // should check in the database
        return true;
    }
}

public static class JwtManager
{
    public static string GenerateToken(string username)
    {
        var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("your_secret_key_here"));
        var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

        var token = new JwtSecurityToken(
            issuer: "your_issuer_here",
            audience: "your_audience_here",
            claims: new[]
            {
                new Claim(ClaimTypes.Name, username)
            },
            expires: DateTime.UtcNow.AddMinutes(30),
            signingCredentials: credentials
        );

        return new JwtSecurityTokenHandler().WriteToken(token);
    }
}