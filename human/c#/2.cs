csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var privateKey = @"-----BEGIN RSA PRIVATE KEY-----
{ the full PEM private key }
-----END RSA PRIVATE KEY-----";

        var rsa = RSA.Create();
        rsa.ImportFromPem(privateKey.ToCharArray());

        var decryptedBytes = rsa.Decrypt(
            Convert.FromBase64String("{ base64-encoded encrypted string }"),
            RSAEncryptionPadding.Pkcs1
        );

        Console.WriteLine(Encoding.UTF8.GetString(decryptedBytes));
    }
}