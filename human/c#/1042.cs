csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static async Task Main()
    {
        var plaintext = Encoding.UTF8.GetBytes("The quick brown fox jumps over the lazy dog");
        var password = "my password";
        var salt = Convert.FromBase64String("MDEyMzQ1Njc4OTAx");

        var ciphertextB64 = await EncryptStringAES256(password, salt, plaintext);
        Console.WriteLine(ciphertextB64);
    }

    static byte[] B642AB(string base64String)
    {
        return Convert.FromBase64String(base64String);
    }

    static string AB2B64(byte[] arrayBuffer)
    {
        return Convert.ToBase64String(arrayBuffer);
    }

    static async Task<string> EncryptStringAES256(string password, byte[] salt, byte[] plaintext)
    {
        var keyMaterial = await GetKeyMaterial(password);
        var key = DeriveKey(keyMaterial, salt);

        using var aes = Aes.Create();
        aes.Key = key;
        aes.IV = salt;
        aes.Mode = CipherMode.GCM;

        using var ms = new MemoryStream();
        using var cs = new CryptoStream(ms, aes.CreateEncryptor(), CryptoStreamMode.Write);
        cs.Write(plaintext, 0, plaintext.Length);
        cs.FlushFinalBlock();

        return AB2B64(ms.ToArray());
    }

    static async Task<byte[]> GetKeyMaterial(string password)
    {
        var enc = Encoding.UTF8;
        return enc.GetBytes(password);
    }

    static byte[] DeriveKey(byte[] keyMaterial, byte[] salt)
    {
        using var pbkdf2 = new Rfc2898DeriveBytes(keyMaterial, salt, 100000);
        return pbkdf2.GetBytes(32);
    }
}