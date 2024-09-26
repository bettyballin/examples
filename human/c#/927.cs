csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    public static void Main()
    {
        Demo();
    }

    public static void Demo()
    {
        using (SHA256 sha256 = SHA256.Create())
        {
            string textToHash = "Hello, World!";
            byte[] bytesToHash = Encoding.UTF8.GetBytes(textToHash);            
            byte[] hash = sha256.ComputeHash(bytesToHash);
            string hexDigest = ToHexStr(hash);

            Console.WriteLine(hexDigest);
        }
    }

    public static string ToHexStr(byte[] hash)
    {
        StringBuilder hex = new StringBuilder(hash.Length * 2);
        foreach (byte b in hash)
            hex.AppendFormat("{0:x2}", b);
        return hex.ToString();
    }
}