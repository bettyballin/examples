csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        using (var ms = new MemoryStream())
        {
            SHA256 hashAlg = new SHA256Managed();
            CryptoStream cs = new CryptoStream(ms, hashAlg, CryptoStreamMode.Write);
            using (var sw = new StreamWriter(cs))
            {
                // Write data here
                sw.WriteLine("Hello, World!");
            }
            cs.FlushFinalBlock();
            byte[] hash = hashAlg.Hash;
            Console.WriteLine(BitConverter.ToString(hash));
        }
    }
}