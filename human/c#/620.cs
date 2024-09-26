csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        var sha256 = CreateSHA256();
        Console.WriteLine(sha256.ToString());
    }

    static SHA256 CreateSHA256()
    {
        return (SHA256)CryptoConfig.CreateFromName("SHA-256");
    }
}