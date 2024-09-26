csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        var salt = GenerateRandomBytes(16);
        var iv = GenerateRandomBytes(12);
        var iterations = 25000;

        var data = "The quick brown fox jumps over the lazy dog";
        var passphrase = "my passphrase";

        var ct = await Encrypt(passphrase, data, iv, salt);
        var dt = await Decrypt(passphrase, ct);

        Console.WriteLine(ct);
        Console.WriteLine(dt);
    }

    static async Task<string> Encrypt(string passphrase, string data, byte[] iv, byte[] salt)
    {
        var key = await DeriveKey(passphrase, salt, iterations);
        var buffer = Encoding.UTF8.GetBytes(data);

        using (var aes = AesGcm.Create())
        {
            aes.Key = key;
            aes.IV = iv;

            var encrypted = aes.Encrypt(buffer, null);
            var bytes = new byte[salt.Length + iv.Length + encrypted.Length];
            Array.Copy(salt, 0, bytes, 0, salt.Length);
            Array.Copy(iv, 0, bytes, salt.Length, iv.Length);
            Array.Copy(encrypted, 0, bytes, salt.Length + iv.Length, encrypted.Length);

            return Convert.ToBase64String(bytes);
        }
    }

    static async Task<string> Decrypt(string passphrase, string data)
    {
        var bytes = Convert.FromBase64String(data);
        var salt = new byte[16];
        var iv = new byte[12];
        var encrypted = new byte[bytes.Length - salt.Length - iv.Length];

        Array.Copy(bytes, 0, salt, 0, salt.Length);
        Array.Copy(bytes, salt.Length, iv, 0, iv.Length);
        Array.Copy(bytes, salt.Length + iv.Length, encrypted, 0, encrypted.Length);

        var key = await DeriveKey(passphrase, salt, 25000);

        using (var aes = AesGcm.Create())
        {
            aes.Key = key;
            aes.IV = iv;

            var decrypted = aes.Decrypt(encrypted, null);
            return Encoding.UTF8.GetString(decrypted);
        }
    }

    static async Task<byte[]> DeriveKey(string passphrase, byte[] salt, int iterations)
    {
        var buffer = Encoding.UTF8.GetBytes(passphrase);

        using (var pbkdf2 = new Rfc2898DeriveBytes(buffer, salt, iterations))
        {
            return pbkdf2.GetBytes(32);
        }
    }

    static byte[] GenerateRandomBytes(int length)
    {
        using (var rng = RandomNumberGenerator.Create())
        {
            var bytes = new byte[length];
            rng.GetBytes(bytes);
            return bytes;
        }
    }
}