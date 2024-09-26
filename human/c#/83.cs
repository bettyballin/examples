csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class DESCrypt
{
    private Byte[] CryptoKey
    {
        get { return new Byte[] { 0x0E, 0x41, 0x6A, 0x29, 0x94, 0x12, 0xEB, 0x63 }; }
    }

    public Byte[] Encrypt(Byte[] bytes)
    {
        using (var crypto = new DESCryptoServiceProvider())
        {
            var key = CryptoKey;

            using (var encryptor = crypto.CreateEncryptor(key, key))
            {
                return encryptor.TransformFinalBlock(bytes, 0, bytes.Length);
            }
        }
    }

    public Byte[] Decrypt(Byte[] bytes)
    {
        using (var crypto = new DESCryptoServiceProvider())
        {
            var key = CryptoKey;

            using (var decryptor = crypto.CreateDecryptor(key, key))
            {
                return decryptor.TransformFinalBlock(bytes, 0, bytes.Length);
            }
        }
    }

    public static void Main(string[] args)
    {
        var crypt = new DESCrypt();
        var bytes = Encoding.UTF8.GetBytes("Hello, World!");
        Console.WriteLine("Original: " + Encoding.UTF8.GetString(bytes));

        var encrypted = crypt.Encrypt(bytes);
        Console.WriteLine("Encrypted: " + BitConverter.ToString(encrypted));

        var decrypted = crypt.Decrypt(encrypted);
        Console.WriteLine("Decrypted: " + Encoding.UTF8.GetString(decrypted));
    }
}