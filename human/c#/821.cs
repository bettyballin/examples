csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main(string[] args)
    {
        var certificate = new X509Certificate2("path_to_your_certificate.pfx", "password");
        var digest = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // replace with your digest

        var hasCng = certificate.HasCngKey();
        if (hasCng)
        {
            var privateKey = certificate.GetCngPrivateKey();
            Console.WriteLine("tiene CNG");
            var key = new RSACng(privateKey);
            key.SignatureHashAlgorithm = CngAlgorithm.Sha1;
            var p = key.SignData(digest);
            Console.WriteLine(Convert.ToBase64String(p));
        }
        else
        {
            Console.WriteLine("No CNG key found");
        }
    }
}