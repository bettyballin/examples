csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // Assuming publicKey is a base64 encoded string
        string publicKey = "your_base64_encoded_public_key";

        // Decode public key
        byte[] publicKeyBytes = Convert.FromBase64String(publicKey);
        RSAParameters rsaParams = new RSAParameters();
        rsaParams.ImportSubjectPublicKeyInfo(publicKeyBytes, out _);
        RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
        rsa.ImportParameters(rsaParams);

        // Encrypt plaintext
        byte[] plaintext = Encoding.UTF8.GetBytes("your_plaintext");
        byte[] crypted = rsa.Encrypt(plaintext, RSAEncryptionPadding.OaepSHA256);

        // Print encrypted bytes
        Console.WriteLine(BitConverter.ToString(crypted));
    }
}