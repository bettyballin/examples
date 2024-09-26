csharp
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;
using Org.BouncyCastle.X509;
using System;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        // Load certificate
        using (var certStream = new FileStream("path/to/your/certificate.crt", FileMode.Open))
        {
            var cert = new X509CertificateParser().ReadCertificate(certStream);

            // Load RSA key
            using (var keyStream = new FileStream("path/to/your/privatekey.key", FileMode.Open))
            {
                var keyReader = new StreamReader(keyStream);
                var pemReader = new PemReader(keyReader);
                var privateKey = pemReader.ReadObject() as AsymmetricCipherKeyPair;

                var publicKey = cert.GetPublicKey();

                ISigner signer = SignerUtilities.GetSigner(cert.SigAlgName);

                // Init for signing, you pass in the private key
                signer.Init(true, privateKey.Private);

                // Init for verification, you pass in the public key
                signer.Init(false, publicKey);
            }
        }
    }
}