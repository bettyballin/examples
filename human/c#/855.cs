csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] message = Encoding.UTF8.GetBytes("Hello, World!");
        string hashAlgorithm = HashAlgorithmName.SHA256.Name;
        RSASignaturePadding paddingMode = RSASignaturePadding.Pkcs1;

        using (RSA rsa = new RSACng())
        {
            byte[] signature = rsa.SignData(message, HashAlgorithmName.Create(hashAlgorithm), paddingMode);
            Console.WriteLine(Convert.ToBase64String(signature));
        }
    }
}