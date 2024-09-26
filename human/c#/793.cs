csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var recipientPublic = Convert.FromBase64String("your-public-key-here");
        var ephem = ECDiffieHellman.Create();

        var ek = ephem.DeriveKeyFromHash(
            recipientPublic,
            HashAlgorithmName.SHA256,
            null,
            new byte[] { 0, 0, 0, 1 });

        var mk = ephem.DeriveKeyFromHash(
            recipientPublic,
            HashAlgorithmName.SHA256,
            null,
            new byte[] { 0, 0, 0, 2 });

        Console.WriteLine($"Ephemeral key: {Convert.ToBase64String(ek)}");
        Console.WriteLine($"Master key: {Convert.ToBase64String(mk)}");
    }
}