csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        Console.WriteLine(TryLogin("test@example.com", "password123"));
    }

    public static bool TryLogin(string email, string password)
    {
        bool userExists = UserExists(email);

        var hash = GetRealPasswordHash(email);
        var hash2 = GetHash(email, password);
        return SlowEquals(hash, hash2) && userExists;
    }

    public static bool UserExists(string email)
    {
        // Replace with actual user existence check
        return true;
    }

    public static string GetRealPasswordHash(string email)
    {
        // Replace with actual password hash retrieval
        return "abc123";
    }

    public static string GetHash(string email, string password)
    {
        using (var sha256 = SHA256.Create())
        {
            var bytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
            return BitConverter.ToString(bytes).Replace("-", "").ToLower();
        }
    }

    public static bool SlowEquals(string a, string b)
    {
        int diff = a.Length ^ b.Length;
        for (int i = 0; i < a.Length && i < b.Length; i++)
        {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}