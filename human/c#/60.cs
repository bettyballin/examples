csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        RSAParameters parameters = new RSAParameters()
        {
            Modulus = Convert.FromBase64String("your_modulus_value"),
            Exponent = Convert.FromBase64String("your_exponent_value")
        };

        RSA rsa = RSA.Create();
        rsa.ImportParameters(parameters);

        string dataToEncrypt = "Hello, World!";
        byte[] dataToEncryptBytes = Encoding.UTF8.GetBytes(dataToEncrypt);

        byte[] encryptedData = rsa.Encrypt(dataToEncryptBytes, RSAEncryptionPadding.OaepSHA1);

        Console.WriteLine("Encrypted Data: " + Convert.ToBase64String(encryptedData));
    }
}