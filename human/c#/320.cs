csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main(string[] args)
    {
        // Load the certificate from a file or other source
        X509Certificate2 x509certificateobject = new X509Certificate2("path_to_your_certificate.pfx", "your_password");

        // Check if the certificate has a private key
        if (x509certificateobject.HasPrivateKey)
        {
            RSACryptoServiceProvider rsaCsp = (RSACryptoServiceProvider)x509certificateobject.PrivateKey;
            // Use the rsaCsp object as needed
        }
        else
        {
            Console.WriteLine("The certificate does not have a private key.");
        }
    }
}