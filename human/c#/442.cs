csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class PasswordHasher
{
    public static string CreateHash(string password)
    {
        using var sha256 = SHA256.Create();
        var hashedBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
        var sb = new StringBuilder();
        foreach (var b in hashedBytes)
        {
            sb.Append(b.ToString("x2"));
        }
        return sb.ToString();
    }

    public static bool Verify(string hash, string password)
    {
        var hashedPassword = CreateHash(password);
        return hashedPassword == hash;
    }
}

public class User
{
    private string PasswordHash { get; set; }

    public void SetPassword(string newPassword)
    {
        PasswordHash = PasswordHasher.CreateHash(newPassword);
    }

    public bool VerifyPassword(string passwordCandidate)
    {
        return PasswordHasher.Verify(PasswordHash, passwordCandidate);
    }
}

public class Program
{
    public static void Main()
    {
        var user = new User();
        user.SetPassword("MySecurePassword");

        Console.WriteLine(user.VerifyPassword("MySecurePassword")); // True
        Console.WriteLine(user.VerifyPassword("IncorrectPassword")); // False
    }
}