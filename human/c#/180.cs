csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string nonce = "1234567890";
        string created = "2022-01-01T12:00:00Z";
        string usernameToken = "username";

        string passwordDigest = CalculatePasswordDigest(nonce, created, usernameToken);

        Console.WriteLine(passwordDigest);
    }

    public static string CalculatePasswordDigest(string nonce, string created, string usernameToken)
    {
        byte[] bytes = Encoding.UTF8.GetBytes(nonce + created + usernameToken);
        using (SHA1 sha1 = SHA1.Create())
        {
            byte[] hash = sha1.ComputeHash(bytes);
            return Convert.ToBase64String(hash);
        }
    }
}