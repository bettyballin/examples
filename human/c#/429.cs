csharp
using System;
using System.IdentityModel.Tokens;

public class CustomIssuerNameRegistry : ValidatingIssuerNameRegistry
{
    public override bool ContainsName(string issuerName)
    {
        return true;
    }

    public override string[] GetIssuerNames()
    {
        return new string[] { "http://example.com" };
    }

    public override void Validate(string issuerName)
    {
        if (issuerName != "http://example.com")
        {
            throw new SecurityTokenException("Invalid issuer name");
        }
    }
}

class Program
{
    static void Main()
    {
        ValidatingIssuerNameRegistry registry = new CustomIssuerNameRegistry();
        registry.Validate("http://example.com");
        registry.Validate("http://invalid.com");
    }
}