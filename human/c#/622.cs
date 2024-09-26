csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string pfxPath = "example.pfx";
        string pfxPassword = "password123";

        using (var key = CngKey.Create(CngAlgorithm.ECDsaP256))
        {
            // NB! X509Certificate2 does not implement IDisposable in .NET 4.5.2, but it does in 4.6.1.
            using (var cert = key.CreateSelfSignedCertificate(new X509CertificateCreationParameters(new X500DistinguishedName("CN=Example Name"))
            {
                StartTime = DateTime.Now,
                EndTime = DateTime.MaxValue,
                TakeOwnershipOfKey = true,
                SignatureAlgorithm = X509CertificateSignatureAlgorithm.ECDsaSha256 // Manually match your CngKey type (RSA/ECDSA)
            }))
            {
                File.WriteAllBytes(pfxPath, cert.Export(X509ContentType.Pkcs12, pfxPassword));
            }
        }
    }
}