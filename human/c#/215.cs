csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        // Load the public certificate
        X509Certificate2 publicCert = new X509Certificate2("path_to_your_public_certificate.cer");

        // Data to verify
        byte[] data = System.Text.Encoding.UTF8.GetBytes("Data to verify");

        // Signature to verify
        byte[] sig = Convert.FromBase64String("your_signature_in_base64");

        // Verify the signature
        RSACryptoServiceProvider key = (RSACryptoServiceProvider)publicCert.PublicKey.Key;
        if (!key.VerifyData(data, CryptoConfig.MapNameToOID("SHA256"), sig))
            throw new CryptographicException();
    }
}