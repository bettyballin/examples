csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string plainPassword = "mysecretpassword";
        byte[] salt = new byte[16];
        using (var rng = RandomNumberGenerator.Create())
        {
            rng.GetBytes(salt);
        }
        string hashedPassword = GetHashedPassword(plainPassword, salt);
        Console.WriteLine(hashedPassword);
    }

    public static string GetHashedPassword(string plainPassword, byte[] salt)
    {
        byte[] passwordBytes = GetBytes(plainPassword);

        // Merge the password bytes and the salt bytes
        var mergedBytes = new byte[passwordBytes.Length + salt.Length];
        Array.Copy(passwordBytes, mergedBytes, passwordBytes.Length);
        Array.Copy(salt, 0, mergedBytes, passwordBytes.Length, salt.Length);

        // Now hash password + salt
        byte[] hash;
        using (var sha = SHA256.Create()) {
            hash = sha.ComputeHash(mergedBytes);
        }
        return Base64Encode(hash);
    }

    public static byte[] GetBytes(string str)
    {
        return Encoding.UTF8.GetBytes(str);
    }

    public static string Base64Encode(byte[] bytes)
    {
        return Convert.ToBase64String(bytes);
    }
}