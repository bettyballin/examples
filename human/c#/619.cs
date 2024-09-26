csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var hashAlgorithm = GetHashAlgorithm();
        Console.WriteLine(hashAlgorithm);
    }

    static HashAlgorithm GetHashAlgorithm()
    {
        return (HashAlgorithm)CryptoConfig.CreateFromName("System.Security.Cryptography.SHA256");
    }
}