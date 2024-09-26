csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        CngKey ECDHKey = CngKey.Create(CngAlgorithm.ECDiffieHellmanP256);
        CngKey ECDSAKey = CngKey.Create(CngAlgorithm.ECDsaP256);

        Console.WriteLine(ECDHKey.Algorithm);
        Console.WriteLine(ECDHKey.AlgorithmGroup);

        Console.WriteLine(ECDSAKey.Algorithm);
        Console.WriteLine(ECDSAKey.AlgorithmGroup);

        using (var ECDH = new ECDiffieHellmanCng(key: ECDHKey))
        {
            Console.WriteLine($"Signature Algorithm: {ECDH.SignatureAlgorithm}");
        }

        using (var ECDSA = new ECDsaCng(key: ECDHKey))
        {
            Console.WriteLine($"Signature Algorithm: {ECDSA.SignatureAlgorithm}");
        }

        using (var ECDSA = new ECDsaCng(key: ECDSAKey))
        {
            Console.WriteLine($"Signature Algorithm: {ECDSA.SignatureAlgorithm}");
        }
    }
}