csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] key = Encoding.UTF8.GetBytes("Your256BitKeyHere01234567890123456789012345678901234567890123456789012345678901");
        byte[] IV = Encoding.UTF8.GetBytes("Your128BitIVHere0123456789012345");

        AesManaged aes = new AesManaged();
        aes.BlockSize = 128;
        aes.KeySize = 256;
        aes.Key = key;
        aes.IV = IV;
        aes.Mode = CipherMode.CBC;

        // Example usage:
        string plainText = "Hello, World!";
        byte[] encryptedBytes = EncryptString(aes, plainText);
        string decryptedText = DecryptString(aes, encryptedBytes);

        Console.WriteLine("Plain Text: " + plainText);
        Console.WriteLine("Encrypted Text: " + Convert.ToBase64String(encryptedBytes));
        Console.WriteLine("Decrypted Text: " + decryptedText);
    }

    static byte[] EncryptString(AesManaged aes, string plainText)
    {
        ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
        byte[] plainBytes = Encoding.UTF8.GetBytes(plainText);
        return encryptor.TransformFinalBlock(plainBytes, 0, plainBytes.Length);
    }

    static string DecryptString(AesManaged aes, byte[] encryptedBytes)
    {
        ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
        byte[] plainBytes = decryptor.TransformFinalBlock(encryptedBytes, 0, encryptedBytes.Length);
        return Encoding.UTF8.GetString(plainBytes);
    }
}