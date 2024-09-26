csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private static string salt = "your_fixed_length_salt";
    private static string sensitiveKey = "your_sensitive_key";
    private static string salted_key = salt + sensitiveKey;

    public static void Main()
    {
        string input = "your_input_string";
        string encrypted = Encrypt(input);
        Console.WriteLine(encrypted);
    }

    public static string Encrypt(string input)
    {
        // Get the bytes of the string
        byte[] passwordBytes = Encoding.UTF8.GetBytes(salted_key);
        // Hash the password with SHA256
        passwordBytes = SHA256.Create().ComputeHash(passwordBytes);
        byte[] bytesEncrypted = EncryptStringToBytes_Aes(input, passwordBytes);
        string result = Convert.ToBase64String(bytesEncrypted);
        return result;
    }

    static byte[] EncryptStringToBytes_Aes(string plainText, byte[] Key)
    {
        if (plainText == null || plainText.Length <= 0)
            throw new ArgumentNullException("plainText");
        if (Key == null || Key.Length <= 0)
            throw new ArgumentNullException("Key");
        byte[] encrypted;
        using (Aes aesAlg = Aes.Create())
        {
            aesAlg.Key = Key;
            ICryptoTransform encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV);
            using (MemoryStream msEncrypt = new MemoryStream())
            {
                using (CryptoStream csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))
                {
                    using (StreamWriter swEncrypt = new StreamWriter(csEncrypt))
                    {
                        swEncrypt.Write(plainText);
                    }
                    encrypted = msEncrypt.ToArray();
                }
            }
        }
        return encrypted;
    }
}