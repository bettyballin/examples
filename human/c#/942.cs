csharp
using System;
using System.Text;
using Microsoft.IdentityModel.Tokens;

public class DomainJWTParams
{
    public string IssuerSigningKey { get; set; }
}

public class Program
{
    public static void Main()
    {
        DomainJWTParams domainJWTParams = new DomainJWTParams
        {
            IssuerSigningKey = "Your issuer signing key here"
        };

        SecurityKey signingKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(domainJWTParams.IssuerSigningKey));
    }
}