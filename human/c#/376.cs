csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string MD5Hash(string input)
    {
        using (var md5 = MD5.Create())
        {
            var bytes = md5.ComputeHash(Encoding.UTF8.GetBytes(input));
            var builder = new StringBuilder();
            for (var i = 0; i < bytes.Length; i++)
            {
                builder.Append(bytes[i].ToString("x2"));
            }
            return builder.ToString();
        }
    }

    public static void Main()
    {
        var password = "your_password";
        var salt = "your_salt";

        var hash0 = "";
        var hash1 = MD5Hash(hash0 + password + salt);
        var hash2 = MD5Hash(hash1 + password + salt);
        var hash3 = MD5Hash(hash2 + password + salt);

        var key = hash1 + hash2;
        var iv = hash3;

        Console.WriteLine("Hash1: " + hash1);
        Console.WriteLine("Hash2: " + hash2);
        Console.WriteLine("Hash3: " + hash3);
        Console.WriteLine("Key: " + key);
        Console.WriteLine("IV: " + iv);
    }
}