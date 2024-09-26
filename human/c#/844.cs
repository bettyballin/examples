csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static bool VerifyPassword(string enteredPassword, string storedHash, string storedSalt)
    {
        var saltBytes = Convert.FromBase64String(storedSalt);
        var rfc2898DeriveBytes = new Rfc2898DeriveBytes(enteredPassword, saltBytes, 10000);
        return Convert.ToBase64String(rfc2898DeriveBytes.GetBytes(256)) == storedHash;
    }

    public static void Main()
    {
        string storedHash = "your_stored_hash_value";
        string storedSalt = "your_stored_salt_value";
        string enteredPassword = "your_entered_password";

        bool isValid = VerifyPassword(enteredPassword, storedHash, storedSalt);
        Console.WriteLine("Is password valid? " + isValid);
    }
}