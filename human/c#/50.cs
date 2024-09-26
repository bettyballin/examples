csharp
using System;
using System.Security.Cryptography;

class Program
{
    protected static readonly RandomNumberGenerator _rng = new RNGCryptoServiceProvider();

    static void Main()
    {
        byte[] randomBytes = new byte[4];
        _rng.GetBytes(randomBytes);
        int randomNumber = BitConverter.ToInt32(randomBytes, 0);
        Console.WriteLine(randomNumber);
    }
}