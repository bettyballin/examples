I need the actual C# code you'd like me to make executable. You've only provided a description of the code, not the code itself. Please provide the code, and I'll do my best to assist you. 

If you are referring to the System.IdentityModel.Tokens.ValidatingIssuerNameRegistry you can use the following code:

csharp
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens;
using System.Security.Claims;
using System.Web;
using Microsoft.IdentityModel.Tokens;

public class TokenValidation
{
    private const string IssuerName = "https://sts.windows.net/your-tenant-id/";
    private const string Audience = "https://your-audience.com";

    public void ValidateToken(string token)
    {
        try
        {
            var tokenHandler = new JwtSecurityTokenHandler();
            var validationParameters = new TokenValidationParameters
            {
                ValidateIssuer = true,
                ValidateAudience = true,
                ValidateLifetime = true,
                ValidateIssuerSigningKey = true,
                ValidIssuer = IssuerName,
                ValidAudience = Audience,
                IssuerSigningKeys = GetSecurityKeys()
            };

            var principal = tokenHandler.ValidateToken(token, validationParameters, out SecurityToken validatedToken);

            var identity = principal.Identity as ClaimsIdentity;

            if (identity != null)
            {
                var claims = identity.Claims;
                foreach (var claim in claims)
                {
                    Console.WriteLine($"{claim.Type} : {claim.Value}");
                }
            }
        }
        catch (SecurityTokenException ex)
        {
            Console.WriteLine($"Security Token Exception: {ex.Message}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Exception: {ex.Message}");
        }
    }

    private List<SecurityKey> GetSecurityKeys()
    {
        var keys = new List<SecurityKey>();

        var key = new X509SecurityKey(new X509Certificate2("path-to-certificate"));
        keys.Add(key);

        return keys;
    }
}