csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class PublicKeyReader
{
    public static void Main()
    {
        string publicKeyString = @"
-----BEGIN PUBLIC KEY-----
MIIB...
...AQAB
-----END PUBLIC KEY-----
";

        publicKeyString = publicKeyString.Trim();

        var bytes = Convert.FromBase64String(publicKeyString
            .Replace("-----BEGIN PUBLIC KEY-----", "")
            .Replace("-----END PUBLIC KEY-----", "")
            .Trim());

        using var rsa = RSA.Create();
        rsa.ImportSubjectPublicKeyInfo(bytes, out _);

        var parameters = rsa.ExportParameters(false);

        Console.WriteLine($"Modulus: {Convert.ToBase64String(parameters.Modulus)}");
        Console.WriteLine($"Exponent: {Convert.ToBase64String(parameters.Exponent)}");
    }
}