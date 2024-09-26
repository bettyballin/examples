csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 cert = new X509Certificate2("path_to_your_certificate.pfx", "password");
        ECDiffieHellman ecdh = GetECDiffieHellman(cert);
        Console.WriteLine(ecdh.ToString());
    }

    static ECDiffieHellman GetECDiffieHellman(X509Certificate2 cert)
    {
        using (ECDsa ecdsa = cert.GetECDsaPublicKey())
        {
            return ECDiffieHellman.Create(ecdsa.ExportParameters(false));
        }
    }
}