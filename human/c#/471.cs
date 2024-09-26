csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (var rng = new RNGCryptoServiceProvider())
        {
            var buffer = new byte[16];
            rng.GetBytes(buffer);
            Console.WriteLine(BitConverter.ToString(buffer));
        }
    }
}