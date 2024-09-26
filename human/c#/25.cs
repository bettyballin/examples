csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        int keySizeInBits = 192; // or 128 or 256
        using (var tdes = new TripleDESCryptoServiceProvider { 
            KeySize = keySizeInBits, 
            Padding = PaddingMode.None 
        })
        {
            Console.WriteLine("TripleDES object created successfully.");
        }
    }
}