csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string password = "your_password";
        string plaintext = "Hello, World!";
        SymmetricAlgorithm algorithm = Aes.Create();

        byte[] encrypted = Encrypt(password, plaintext, algorithm);

        Console.WriteLine("Encrypted: " + Convert.ToBase64String(encrypted));
    }

    public static byte[] Encrypt(string password, string plaintext, SymmetricAlgorithm algorithm)
    {
        byte[] key, iv;
        CreateKeyIV(password, out key, out iv);
        using (MemoryStream encrypted = new MemoryStream())
        {
            using (CryptoStream enc = new CryptoStream(encrypted, algorithm.CreateEncryptor(key, iv), CryptoStreamMode.Write))
            using (StreamWriter writer = new StreamWriter(enc))
                writer.Write(plaintext);
            return encrypted.ToArray();
        }
    }

    public static void CreateKeyIV(string password, out byte[] key, out byte[] iv)
    {
        using (Aes aes = Aes.Create())
        {
            Rfc2898DeriveBytes deriveBytes = new Rfc2898DeriveBytes(password, new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 });
            key = deriveBytes.GetBytes(32);
            iv = deriveBytes.GetBytes(16);
        }
    }
}