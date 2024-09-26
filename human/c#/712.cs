Here is the executable C# code:

csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    private static byte[] key = Encoding.UTF8.GetBytes("4512631236589784");
    private static byte[] iv = Encoding.UTF8.GetBytes("4512631236589784");

    static void Main(string[] args)
    {
        string data = "Your Json Object data or string";
        string encrypted = EncryptUsingAES256(data);
        Console.WriteLine("Encrypted: " + encrypted);
        string decrypted = DecryptUsingAES256(encrypted);
        Console.WriteLine("Decrypted: " + decrypted);
    }

    static string EncryptUsingAES256(string data)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider())
        {
            aes.Key = key;
            aes.IV = iv;
            aes.BlockSize = 128;
            aes.Mode = CipherMode.CBC;
            aes.Padding = PaddingMode.PKCS7;

            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
            byte[] encrypted;

            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, encryptor, CryptoStreamMode.Write))
                {
                    using (StreamWriter sw = new StreamWriter(cs))
                    {
                        sw.Write(data);
                    }
                    encrypted = ms.ToArray();
                }
            }
            return Convert.ToBase64String(encrypted);
        }
    }

    static string DecryptUsingAES256(string encrypted)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider())
        {
            aes.Key = key;
            aes.IV = iv;
            aes.BlockSize = 128;
            aes.Mode = CipherMode.CBC;
            aes.Padding = PaddingMode.PKCS7;

            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
            byte[] decrypted;

            using (MemoryStream ms = new MemoryStream(Convert.FromBase64String(encrypted)))
            {
                using (CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read))
                {
                    using (StreamReader sr = new StreamReader(cs))
                    {
                        return sr.ReadToEnd();
                    }
                }
            }
        }
    }
}