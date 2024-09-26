csharp
using System;
using System.IO;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string signatureFile = "sig.bin";
        string publicKeyFile = "pub.key";

        byte[] signature = File.ReadAllBytes(signatureFile);
        byte[] publicKeyBytes = File.ReadAllBytes(publicKeyFile);

        using (var rsa = RSA.Create())
        {
            rsa.ImportSubjectPublicKeyInfo(publicKeyBytes, out _);
            bool isValid = rsa.VerifyData(new byte[0], signature, HashAlgorithmName.SHA256, RSASignaturePadding.Pkcs1);

            if (isValid)
            {
                byte[] data = rsa.Decrypt(signature, RSAEncryptionPadding.Pkcs1);
                Console.WriteLine(BitConverter.ToString(data).Replace("-", " "));
            }
            else
            {
                Console.WriteLine("Invalid signature");
            }
        }
    }
}