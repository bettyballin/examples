csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string text = "Hello, World!";
        byte[] baHashedText = HashText(text);
        Console.WriteLine(BitConverter.ToString(baHashedText).Replace("-", "").ToLowerInvariant());
    }

    static byte[] HashText(string text)
    {
        using (var sha256 = SHA256.Create())
        {
            return sha256.ComputeHash(Encoding.UTF8.GetBytes(text));
        }
    }
}