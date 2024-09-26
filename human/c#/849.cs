csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (ECDiffieHellman ecdh = ECDiffieHellman.Create())
        {
            ecdh.KeySize = 384;
            Console.WriteLine(ecdh.KeySize);
        }
    }
}