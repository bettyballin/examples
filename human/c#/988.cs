csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        var passphrase = Encoding.UTF8.GetBytes("a sample passphrase");
        var salt = Encoding.UTF8.GetBytes("a sample salt");

        using var pbkdf2 = new Rfc2898DeriveBytes(passphrase, salt, 10000);
        var key = pbkdf2.GetBytes(16);

        Console.WriteLine("raw key: " + BitConverter.ToString(key));

        using var aes = Aes.Create();
        aes.Key = key;
        aes.Mode = CipherMode.CBC;

        Console.WriteLine("CryptoKey: " + aes.Key);
    }
}