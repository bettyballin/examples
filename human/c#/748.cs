csharp
using System;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        var cert = new X509Certificate2("path_to_your_certificate.pfx");
        var rsa = cert.GetRSAPrivateKey();

        var derData = new byte[]
        {
            0x30, 0x82, 0x04, 0x00, // SEQUENCE (SignedData)
            0x02, 0x01, 0x01, // INTEGER (Version=1)
            0x31, 0x0D, // SET (OF DigestAlgorithmIdentifier (digestAlgorithms))
            0x30, 0x0B, // SEQUENCE (DigestAlgorithmIdentifier ::= AlgorithmIdentifier)
            0x06, 0x09, 0x60, 0x86, 0x48, 0x01, 0x65, 0x03, 0x04, 0x02, 0x01, // OBJECT IDENTIFIER (2.16.840.1.101.3.4.2.1 == SHA-2-256)
            0x30, 0x46, // SEQUENCE (EncapsulatedContentInfo)
            0x06, 0x09, 0x2A, 0x86, 0x48, 0x86, 0xF7, 0x0D, 0x01, 0x07, 0x01, // OBJECT IDENTIFIER (1.2.840.113549.1.7.1 == pkcs7-data)
            0xA0, 0x1F, // CONTEXT SPECIFIC 0 - CONSTRUCTED
            0x04, 0x05, 0x48, 0x65, 0x6C, 0x6C, 0x6F, // OCTET STRING (the data goes here)
            0xA0, 0x3F, // CONTEXT SPECIFIC 0 - CONSTRUCTED (CertificateSet (certificates))
            // [cert.RawData goes here, which is already DER encoded]
            0x31, 0x81, // SET (OF SignerInfo (singerInfos))
            0x30, 0x45, // SEQUENCE (SignerInfo)
            0x02, 0x01, 0x01, // INTEGER (Version=1)
            0x30, 0x2D, // SEQUENCE (IssuerAndSerialNumber)
            // [cert.IssuerName.RawData]
            0x02, 0x10, // OCTECT STRING (SerialNumber)
            // [cert.GetSerialNumberBytes()]
            0x30, 0x0B, // SEQUENCE (DigestAlgorithm (digestAlgorithm))
            0x06, 0x09, 0x60, 0x86, 0x48, 0x01, 0x65, 0x03, 0x04, 0x02, 0x01, // OBJECT IDENTIFIER (2.16.840.1.101.3.4.2.1 == SHA-2-256)
            0x30, 0x09, // SEQUENCE (DigestEncryptionAlgorithmIdentifier ::= AlgorithmIdentifier)
            0x06, 0x09, 0x2A, 0x86, 0x48, 0x86, 0xF7, 0x0D, 0x01, 0x01, 0x01, // OBJECT IDENTIFIER (1.2.840.113549.1.1.1 == rsaEncryption)
            0x05, 0x00, // NULL (rsaEncryption says parameters must be explicit NULL)
            0x04, 0x81, // OCTECT STRING (signature)
            // [rsa.SignData(new byte[] { 0x48, 0x65, 0x6C, 0x6C, 0x6F }, HashAlgorithmName.SHA256, RSASignaturePadding.Pkcs1)]
        };

        var signature = rsa.SignData(new byte[] { 0x48, 0x65, 0x6C, 0x6C, 0x6F }, HashAlgorithmName.SHA256, RSASignaturePadding.Pkcs1);

        Array.Copy(cert.RawData, 0, derData, 0x2C, cert.RawData.Length);
        Array.Copy(cert.IssuerName.RawData, 0, derData, 0x4E, cert.IssuerName.RawData.Length);
        Array.Copy(cert.GetSerialNumberBytes(), 0, derData, 0x5E, cert.GetSerialNumberBytes().Length);
        Array.Copy(signature, 0, derData, 0x84, signature.Length);

        Console.WriteLine(BitConverter.ToString(derData));
    }
}