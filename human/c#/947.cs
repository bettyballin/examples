csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string EncryptPassword(string key, string password)
    {
        var encoding = System.Text.Encoding.GetEncoding(1256);
        byte[] passwordBytes = encoding.GetBytes(password);
        byte[] keyBytes = encoding.GetBytes(key);

        using (var aes = AesManaged.Create())
        {
            aes.Padding = PaddingMode.PKCS7;
            aes.Mode = CipherMode.CBC;
            aes.Key = keyBytes;
            aes.BlockSize = 128;
            aes.IV = new byte[16];

            using (var ms = new MemoryStream())
            {
                using (var transform = aes.CreateEncryptor())
                using (var cs = new CryptoStream(ms, transform, CryptoStreamMode.Write))
                {
                    cs.Write(passwordBytes, 0, passwordBytes.Length);
                }
                return BitConverter.ToString(ms.ToArray()).Replace("-", string.Empty);
            }
        }
    }

    public static void Main()
    {
        string key = "your_key_here";
        string password = "your_password_here";
        string encryptedPassword = EncryptPassword(key, password);
        Console.WriteLine("Encrypted Password: " + encryptedPassword);
    }
}