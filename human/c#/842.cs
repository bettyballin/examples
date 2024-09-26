csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class HashSalt
{
    public string Hash { get; set; }
    public string Salt { get; set; }
}

public class Program
{
    public static HashSalt GenerateSaltedHash(int size, string password)
    {
        var saltBytes = new byte[size];
        var provider = new RNGCryptoServiceProvider();
        provider.GetNonZeroBytes(saltBytes);
        var salt = Convert.ToBase64String(saltBytes);

        var rfc2898DeriveBytes = new Rfc2898DeriveBytes(password, saltBytes, 10000);
        var hashPassword = Convert.ToBase64String(rfc2898DeriveBytes.GetBytes(256));

        HashSalt hashSalt = new HashSalt { Hash = hashPassword, Salt = salt };
        return hashSalt;
    }

    public static void Main()
    {
        var password = "MySecurePassword";
        var hashSalt = GenerateSaltedHash(32, password);
        Console.WriteLine("Hash: " + hashSalt.Hash);
        Console.WriteLine("Salt: " + hashSalt.Salt);
    }
}