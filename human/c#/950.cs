csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Security.Cryptography.Pkcs;

public class Program
{
    public static byte[] SignContent(X509Certificate2 certificate, RSA rsa, byte[] contentInfo)
    {
        var signedCms = new SignedCms(new ContentInfo(contentInfo), false);

        using (X509Certificate2 certWithKey = certificate.CopyWithPrivateKey(rsa))
        {
            var signer = new CmsSigner(certWithKey);

            signer.DigestAlgorithm = new Oid("2.16.840.1.101.3.4.2.1");
            signer.SignedAttributes.Add(new Pkcs9SigningTime());

            signedCms.ComputeSignature(signer);
        }

        var encodeByteBlock = signedCms.Encode();
        return encodeByteBlock;
    }

    public static void Main(string[] args)
    {
        // Example usage
        X509Certificate2 certificate = new X509Certificate2("path_to_your_certificate");
        RSA rsa = RSA.Create();
        byte[] contentInfo = System.Text.Encoding.UTF8.GetBytes("Your content to sign");

        byte[] signedContent = SignContent(certificate, rsa, contentInfo);
        Console.WriteLine(BitConverter.ToString(signedContent));
    }
}