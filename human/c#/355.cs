csharp
using System;
using System.IdentityModel.Configuration;
using System.IdentityModel.Tokens;

class Program
{
    static void Main()
    {
        string issuerName = "YourIssuerName";
        SigningCredentials signingCredentials = new SigningCredentials(new X509SecurityKey("YourCertificatePath"), SecurityAlgorithms.RsaSha256Signature);
        string serviceName = "YourServiceName";

        SecurityTokenServiceConfiguration config = new SecurityTokenServiceConfiguration(issuerName, signingCredentials, serviceName);
    }
}