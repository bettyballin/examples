csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // Text
        string text = "Hello, World!";
        Console.WriteLine("Text:");
        Console.WriteLine(text);

        // Encode with UTF-8
        byte[] nonEncryptedBytes = Encoding.UTF8.GetBytes(text);
        Console.WriteLine("Non-encrypted binary data:");
        Console.WriteLine(BitConverter.ToString(nonEncryptedBytes));

        // Encrypt
        byte[] encryptedBytes = Encrypt(nonEncryptedBytes, "password");
        Console.WriteLine("Encrypted binary data:");
        Console.WriteLine(BitConverter.ToString(encryptedBytes));

        // Convert to base64
        string encryptedBase64 = Convert.ToBase64String(encryptedBytes);
        Console.WriteLine("Encrypted data as base64 text:");
        Console.WriteLine(encryptedBase64);

        // Store or whatever...

        // Convert from base64
        byte[] encryptedBytesFromBase64 = Convert.FromBase64String(encryptedBase64);
        Console.WriteLine("Encrypted binary data:");
        Console.WriteLine(BitConverter.ToString(encryptedBytesFromBase64));

        // Decrypt
        byte[] nonEncryptedBytesFromEncrypted = Decrypt(encryptedBytesFromBase64, "password");
        Console.WriteLine("Non-encrypted binary data:");
        Console.WriteLine(BitConverter.ToString(nonEncryptedBytesFromEncrypted));

        // Decode with UTF-8
        string textFromNonEncryptedBytes = Encoding.UTF8.GetString(nonEncryptedBytesFromEncrypted);
        Console.WriteLine("Text:");
        Console.WriteLine(textFromNonEncryptedBytes);
    }

    static byte[] Encrypt(byte[] data, string password)
    {
        byte[] encryptedData;
        using (Aes aes = Aes.Create())
        {
            aes.Key = GetKey(password, aes.KeySize);
            aes.GenerateIV();
            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);

            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, encryptor, CryptoStreamMode.Write))
                {
                    cs.Write(data, 0, data.Length);
                }
                encryptedData = ms.ToArray();
            }
        }
        return encryptedData;
    }

    static byte[] Decrypt(byte[] data, string password)
    {
        byte[] decryptedData;
        using (Aes aes = Aes.Create())
        {
            aes.Key = GetKey(password, aes.KeySize);
            aes.GenerateIV();
            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);

            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Write))
                {
                    cs.Write(data, 0, data.Length);
                }
                decryptedData = ms.ToArray();
            }
        }
        return decryptedData;
    }

    static byte[] GetKey(string password, int keySize)
    {
        byte[] key;
        using (Rfc2898DeriveBytes deriveBytes = new Rfc2898DeriveBytes(password, new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 1000))
        {
            key = deriveBytes.GetBytes(keySize / 8);
        }
        return key;
    }
}