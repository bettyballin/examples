csharp
using System;
using System.IO;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main(string[] args)
    {
        string certificateFile = "path_to_your_certificate_file";
        string certificatePassword = "your_certificate_password";
        string certName = "your_certificate_name";

        X509Certificate2 cert = new X509Certificate2(certificateFile, certificatePassword);
        RSACertificateExtensions.GetRSAPrivateKey(cert);
        X509Certificate2PublicKey publicKey = cert.GetPublicKey();

        using (var rsa = RSA.Create())
        {
            rsa.ImportPkcs8PrivateKey(cert.GetRawPrivateKey(), out _);
            RSAParameters privateKey = rsa.ExportParameters(true);

            KeyPair keys = new KeyPair(publicKey, privateKey);
        }
    }
}

public class KeyPair
{
    public X509Certificate2PublicKey PublicKey { get; set; }
    public RSAParameters PrivateKey { get; set; }

    public KeyPair(X509Certificate2PublicKey publicKey, RSAParameters privateKey)
    {
        PublicKey = publicKey;
        PrivateKey = privateKey;
    }
}