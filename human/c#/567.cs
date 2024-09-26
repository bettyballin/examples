csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string GeneratePasswordHash(string password, string salt)
    {
        Byte[] passwordBytes = Encoding.UTF8.GetBytes(password + salt);
        Byte[] hashedBytes = new SHA256CryptoServiceProvider().ComputeHash(passwordBytes);
        return BitConverter.ToString(hashedBytes).Replace("-", String.Empty);
    }

    public static void Main()
    {
        string password = "mysecretpassword";
        string salt = "mysalt";
        string hashedPassword = GeneratePasswordHash(password, salt);
        Console.WriteLine(hashedPassword);
    }
}