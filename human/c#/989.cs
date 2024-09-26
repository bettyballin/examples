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

        using var deriveBytes = new Rfc2898DeriveBytes(passphrase, salt, 10000);
        var derivedKey = deriveBytes.GetBytes(16);

        using var aes = Aes.Create();
        aes.Key = derivedKey;
        aes.Mode = CipherMode.CBC;
        aes.BlockSize = 128;

        Console.WriteLine("CryptoKey: " + BitConverter.ToString(aes.Key));

        // Export as byte array
        Console.WriteLine("raw key: " + BitConverter.ToString(derivedKey));
    }
}