csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string certificateFile = "path_to_your_certificate.pfx";
        string certificatePassword = "your_certificate_password";

        X509Certificate2 cert = new X509Certificate2(certificateFile, certificatePassword, X509KeyStorageFlags.Exportable | X509KeyStorageFlags.PersistKeySet);
        RSACryptoServiceProvider provider1 = (RSACryptoServiceProvider)cert.PublicKey.Key;
        RSACryptoServiceProvider provider2 = (RSACryptoServiceProvider)cert.PrivateKey;

        Console.WriteLine("Certificate loaded successfully.");
    }
}