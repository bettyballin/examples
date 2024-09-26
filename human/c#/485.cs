csharp
using System;
using System.Security.Cryptography;

public class Program
{
    public static string GetUniqueKey()
    {
        int size = 16;
        byte[] data = new byte[size];
        RNGCryptoServiceProvider crypto = new RNGCryptoServiceProvider();
        crypto.GetBytes(data);
        return BitConverter.ToString(data).Replace("-", String.Empty);
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(GetUniqueKey());
    }
}