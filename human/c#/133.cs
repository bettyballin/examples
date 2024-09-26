csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] buffer = Encoding.UTF8.GetBytes("Hello, World!");
        int bytesReceived = buffer.Length;

        using (HashAlgorithm hasher = SHA256.Create())
        {
            hasher.TransformBlock(buffer, 0, bytesReceived, null, 0);
            hasher.TransformFinalBlock(new byte[0], 0, 0);
            byte[] hash = hasher.Hash;
            Console.WriteLine(BitConverter.ToString(hash));
        }
    }
}