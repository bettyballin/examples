csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main(string[] args)
    {
        // Load certificate from file or store
        var certificate = new X509Certificate2("path_to_your_certificate.pfx", "password");

        // Assuming 'digest' is a byte array containing the data to sign
        byte[] digest = System.Text.Encoding.UTF8.GetBytes("Hello, World!");

        using (RSA rsa = certificate.GetRSAPrivateKey())
        {
            Console.WriteLine("tiene RSA. Que tipo no es importante.");
            var p = rsa.SignData(digest, HashAlgorithmName.SHA1, RSASignaturePadding.Pkcs1);
            Console.WriteLine(Convert.ToBase64String(p));
        }
    }
}