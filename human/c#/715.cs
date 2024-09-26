csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string publicKey = "your_public_key_here";
        string message = "Hello, World!";
        string cipher;

        using (var rsa = RSA.Create())
        {
            rsa.ImportSubjectPublicKeyInfo(Convert.FromBase64String(publicKey), out _);

            var encryptedBytes = rsa.Encrypt(Encoding.UTF8.GetBytes(message), RSAEncryptionPadding.OaepSHA1);

            cipher = Convert.ToBase64String(encryptedBytes);
        }

        Console.WriteLine(cipher);
    }
}