csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        using (var hasher = SHA256.Create())
        {
            hasher.TransformFinalBlock(new byte[0], 0, 0);
            byte[] hash = hasher.Hash;
            Console.WriteLine(BitConverter.ToString(hash));
        }
    }
}