csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

public class Program
{
    public static void Main()
    {
        byte[] bytes = System.Text.Encoding.UTF8.GetBytes("Hello, World!");
        string signature = "your_base64_encoded_signature_here";

        bool isValid = IsMessageSignatureValid(bytes, signature);
        Console.WriteLine($"Signature is valid: {isValid}");
    }

    public static bool IsMessageSignatureValid(byte[] bytes, string signature)
    {
        // New instance each call? If so, dispose this.
        using (X509Certificate2 certificate = GetX509Certificate())
        {
            // GetRSAPublicKey returns a new object each time,
            // you should definitely using/Dispose it.
            using (RSA rsa = certificate.GetRSAPublicKey())
            {
                return rsa.VerifyData(
                    bytes,
                    Convert.FromBase64String(signature),
                    HashAlgorithmName.SHA1,
                    RSASignaturePadding.Pkcs1);
            }
        }
    }

    public static X509Certificate2 GetX509Certificate()
    {
        // Replace with your certificate loading logic
        // For demonstration purposes, we'll just create a new self-signed certificate
        using (RSA rsa = RSA.Create())
        {
            var certRequest = new CertificateRequest("CN=SelfSigned", rsa, HashAlgorithmName.SHA256, RSASignaturePadding.Pkcs1);
            return certRequest.CreateSelfSigned(DateTime.UtcNow, DateTime.UtcNow.AddYears(1));
        }
    }
}