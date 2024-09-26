csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (RSA rsa = RSA.Create(2048))
        {
            byte[] publicKeyBytes = rsa.ExportSubjectPublicKeyInfo();
            Console.WriteLine(BitConverter.ToString(publicKeyBytes));
        }
    }
}