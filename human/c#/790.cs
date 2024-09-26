csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        X509Certificate2 cert = new X509Certificate2("path_to_your_certificate.pfx", "password");
        ECDiffieHellmanPublicKey recipientPublic = GetECDHFromCertificate(cert).PublicKey;
        ECCurve curve = recipientPublic.ExportParameters().Curve;
    }

    static ECDiffieHellman GetECDHFromCertificate(X509Certificate2 cert)
    {
        if (cert == null)
        {
            throw new ArgumentNullException(nameof(cert));
        }

        if (cert.GetECDsaPublicKey() == null)
        {
            throw new ArgumentException("Certificate does not contain an ECDH public key.");
        }

        using (var publicKey = cert.GetECDsaPublicKey())
        {
            return ECDiffieHellman.Create(publicKey.ExportParameters().Curve);
        }
    }
}