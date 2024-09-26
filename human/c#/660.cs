csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class SOPasswordHasher
{
    public static byte[] GetSalt()
    {
        using (var rng = new RNGCryptoServiceProvider())
        {
            var salt = new byte[32];
            rng.GetBytes(salt);
            return salt;
        }
    }

    public static byte[] Hash(string password, byte[] salt)
    {
        using (var pbkdf2 = new Rfc2898DeriveBytes(password, salt, 100000))
        {
            return pbkdf2.GetBytes(32);
        }
    }
}

class Program
{
    static void Main()
    {
        var salt = SOPasswordHasher.GetSalt();
        var result = Convert.ToBase64String(SOPasswordHasher.Hash("hovercraft", salt));
        Console.WriteLine(result);
    }
}