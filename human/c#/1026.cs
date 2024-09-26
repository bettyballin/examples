csharp
using System;
using System.Security.Cryptography;
using System.Text;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Security;

public class Program
{
    public static string GetBearerToken(string publicKeyBase64, string apiKey)
    {
        var keyBytes = Convert.FromBase64String(publicKeyBase64);
        var keyParameter = PublicKeyFactory.CreateKey(keyBytes);
        var rsaKeyParameters = (RsaKeyParameters)keyParameter;
        var rsaParameters = new RSAParameters
        {
            Modulus = rsaKeyParameters.Modulus.ToByteArrayUnsigned(),
            Exponent = rsaKeyParameters.Exponent.ToByteArrayUnsigned()
        };

        using (var rsa = new RSACryptoServiceProvider())
        {
            rsa.ImportParameters(rsaParameters);

            var dataToEncrypt = Encoding.UTF8.GetBytes(apiKey);
            var encryptedBytes = rsa.Encrypt(dataToEncrypt, false);

            return Convert.ToBase64String(encryptedBytes);
        }
    }

    public static void Main(string[] args)
    {
        var publicKeyBase64 = "your-public-key-in-base64";
        var apiKey = "your-api-key";
        var bearerToken = GetBearerToken(publicKeyBase64, apiKey);
        Console.WriteLine(bearerToken);
    }
}