csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Convert;

public class Program
{
    public static void Main()
    {
        string nonce = "your_nonce_here";
        string created = "your_created_here";
        string password = "your_password_here";

        string passwordDigest = GeneratePasswordDigest(nonce, created, password);
        Console.WriteLine(passwordDigest);
    }

    public static string GeneratePasswordDigest(string nonce, string created, string password)
    {
        string input = nonce + created + password;
        byte[] bytes = Encoding.UTF8.GetBytes(input);

        SHA1 sha1 = SHA1.Create();
        byte[] hash = sha1.ComputeHash(bytes);

        return Convert.ToBase64String(hash);
    }
}