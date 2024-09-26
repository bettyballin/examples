csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string GenerateHash(string password, string saltAsBase64)
    {
        byte[] salt = Convert.FromBase64String(saltAsBase64);
        byte[] bytes = Encoding.UTF8.GetBytes(password);
        using (var deriveBytes = new Rfc2898DeriveBytes(bytes, salt, 100000))
        {
            byte[] hashBytes = deriveBytes.GetBytes(32);
            return Convert.ToBase64String(hashBytes);
        }
    }

    public static void Main()
    {
        string pwd = "Letmein44";
        string saltAsBase64 = "SuY4cf8wJXJAVEr3xjz4Dg==";

        string hash = GenerateHash(pwd, saltAsBase64);
        Console.WriteLine(hash);
    }
}