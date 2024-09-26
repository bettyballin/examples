csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        // Create a new RSA key
        using (var rsa = RSA.Create())
        {
            // Create some data to sign
            byte[] data = new byte[1024];

            // Sign the data
            byte[] sig = rsa.SignData(data, HashAlgorithmName.SHA256, RSASignaturePadding.Pkcs1);

            Console.WriteLine(BitConverter.ToString(sig));
        }
    }
}