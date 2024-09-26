csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] key = Encoding.UTF8.GetBytes("your_key_here_32_chars_long");
        byte[] IV = Encoding.UTF8.GetBytes("your_iv_here_16_chars_long");

        AesManaged aes = new AesManaged();
        aes.Key = key;
        aes.IV = IV;
        aes.BlockSize = 128;
        aes.KeySize = 256;
        aes.Mode = CipherMode.CBC;

        string plainText = "Hello World!";
        byte[] encrypted = Encrypt(aes, plainText);
        byte[] decrypted = Decrypt(aes, encrypted);

        Console.WriteLine("Plain Text: " + plainText);
        Console.WriteLine("Encrypted: " + Convert.ToBase64String(encrypted));
        Console.WriteLine("Decrypted: " + Encoding.UTF8.GetString(decrypted));
    }

    static byte[] Encrypt(AesManaged aes, string plainText)
    {
        ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
        byte[] bytes = Encoding.UTF8.GetBytes(plainText);
        byte[] result = encryptor.TransformFinalBlock(bytes, 0, bytes.Length);
        return result;
    }

    static byte[] Decrypt(AesManaged aes, byte[] encrypted)
    {
        ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
        byte[] result = decryptor.TransformFinalBlock(encrypted, 0, encrypted.Length);
        return result;
    }
}