csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider();        
            
        byte[] salt = new byte[16];

        rng.GetBytes(salt);

        Console.WriteLine(BitConverter.ToString(salt));
    }
}