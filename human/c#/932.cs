csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class AesEncryption
{
    public static byte[] Encrypt(byte[] data, Aes aes)
    {
        using (var ms = new MemoryStream())
        {
            using (var cs = new CryptoStream(ms, aes.CreateEncryptor(), CryptoStreamMode.Write))
            {
                cs.Write(data, 0, data.Length);
            }
            return ms.ToArray();
        }
    }

    public static byte[] Decrypt(byte[] data, Aes aes)
    {
        using (var ms = new MemoryStream())
        {
            using (var cs = new CryptoStream(ms, aes.CreateDecryptor(), CryptoStreamMode.Write))
            {
                cs.Write(data, 0, data.Length);
            }
            return ms.ToArray();
        }
    }
}

class Program
{
    static void Main()
    {
        using (var aes = Aes.Create())
        {
            aes.Key = new byte[32]; // Replace with your own key
            aes.IV = new byte[16]; // Replace with your own initialization vector

            var data = Encoding.UTF8.GetBytes("Hello, World!");
            var encrypted = AesEncryption.Encrypt(data, aes);

            File.WriteAllText(@"C:\Users\sepita\Desktop\My.txt", Convert.ToBase64String(encrypted));
            var decrypted = AesEncryption.Decrypt(Convert.FromBase64String(File.ReadAllText(@"C:\Users\sepita\Desktop\My.txt")), aes);

            Console.WriteLine(Encoding.UTF8.GetString(decrypted));
        }
    }
}