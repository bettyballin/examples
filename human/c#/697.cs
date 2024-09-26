csharp
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Threading.Tasks;

public class JwtManager
{
    public static ClaimsPrincipal GetPrincipal(string token)
    {
        var handler = new JwtSecurityTokenHandler();
        var jwtToken = handler.ReadToken(token) as JwtSecurityToken;

        if (jwtToken == null)
            return null;

        var identity = new ClaimsIdentity(jwtToken.Claims, "Jwt");
        var principal = new ClaimsPrincipal(identity);

        return principal;
    }
}

public class TokenValidator
{
    private static bool ValidateToken(string token, out string username)
    {
        username = null;

        var simplePrinciple = JwtManager.GetPrincipal(token);
        var identity = simplePrinciple.Identity as ClaimsIdentity;

        if (identity == null || !identity.IsAuthenticated)
            return false;

        var usernameClaim = identity.FindFirst(ClaimTypes.Name);
        username = usernameClaim?.Value;

        if (string.IsNullOrEmpty(username))
           return false;

        // More validate to check whether username exists in system

        return true;
    }

    protected Task<IPrincipal> AuthenticateJwtToken(string token)
    {
        string username;

        if (ValidateToken(token, out username))
        {
            // based on username to get more information from database 
            // in order to build local identity
            var claims = new List<Claim>
            {
                new Claim(ClaimTypes.Name, username)
                // Add more claims if needed: Roles, ...
            };

            var identity = new ClaimsIdentity(claims, "Jwt");
            IPrincipal user = new ClaimsPrincipal(identity);

            return Task.FromResult(user);
        }

        return Task.FromResult<IPrincipal>(null);
    }
}

public class Program
{
    public static void Main()
    {
        var validator = new TokenValidator();
        var token = "your_jwt_token_here";
        var principal = validator.AuthenticateJwtToken(token).Result;

        if (principal != null)
        {
            Console.WriteLine("Authentication successful");
        }
        else
        {
            Console.WriteLine("Authentication failed");
        }
    }
}