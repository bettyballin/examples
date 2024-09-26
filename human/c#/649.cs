csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        SHA1CryptoServiceProvider SHA1 = new SHA1CryptoServiceProvider();
        var tdes = new TripleDESCryptoServiceProvider();
        tdes.Key = SHA1.ComputeHash(System.Text.Encoding.ASCII.GetBytes("MyTestKey"));
        Console.WriteLine(BitConverter.ToString(tdes.Key));
    }
}