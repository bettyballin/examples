csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (ECDiffieHellman ecdh = ECDiffieHellman.Create(ECCurve.NamedCurves.nistP384))
        {
            Console.WriteLine("ECDH created with curve: " + ecdh.KeySize);
        }
    }
}