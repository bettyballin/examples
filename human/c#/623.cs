csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string pfxPath = "path_to_your_certificate.pfx";
        string pfxPassword = "your_certificate_password";

        using (var cert = new X509Certificate2(pfxPath, pfxPassword))
        {
            var privateKey = cert.GetCngPrivateKey();
            Console.WriteLine(privateKey);
        }
    }
}