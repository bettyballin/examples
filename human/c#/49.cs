csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string GetMD5Hash(string input)
    {
        MD5CryptoServiceProvider x = new MD5CryptoServiceProvider();
        byte[] bs = Encoding.UTF8.GetBytes(input);
        bs = x.ComputeHash(bs);
        StringBuilder s = new StringBuilder();
        foreach (byte b in bs)
        {
            s.Append(b.ToString("x2").ToLower());
        }
        return s.ToString();
    }

    public static void Main()
    {
        Console.Write("Enter a string to hash: ");
        string input = Console.ReadLine();
        string hashed = GetMD5Hash(input);
        Console.WriteLine("MD5 Hash: " + hashed);
    }
}