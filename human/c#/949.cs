csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 certificate = new X509Certificate2("path_to_your_certificate.pfx", "password");
        RSA rsa = RSA.Create();

        using (RSA privateKey = certificate.GetRSAPrivateKey())
        {
            rsa.ImportParameters(privateKey.ExportParameters(true));
            certificate.PrivateKey = rsa;
        }
    }
}