csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (ECDiffieHellman ecdh = ECDiffieHellman.Create())
        {
            ecdh.GenerateKey(ECCurve.NamedCurves.nistP384);
            Console.WriteLine("Generated key:");
            Console.WriteLine(ecdh.PublicKey.ToXmlString());
        }
    }
}