csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    const string Algorithm = "AES";
    const string KEY = "KFmnMAPzP!g@6Dy5HD?JSgYC9obE&m@m";
    const string IV = "KFmnMAPzP!g@6Dy5";

    static string Encrypt(string plainText, string key, string iv, string outputEncoding = "Base64")
    {
        byte[] keyBytes = Encoding.UTF8.GetBytes(key);
        byte[] ivBytes = Encoding.UTF8.GetBytes(iv);
        byte[] plainTextBytes = Encoding.UTF8.GetBytes(plainText);

        using (Aes cipher = Aes.Create())
        {
            cipher.Key = keyBytes;
            cipher.IV = ivBytes;
            cipher.BlockSize = 128;
            cipher.KeySize = 256;
            cipher.Mode = CipherMode.CBC;
            cipher.Padding = PaddingMode.PKCS7;

            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, cipher.CreateEncryptor(), CryptoStreamMode.Write))
                {
                    cs.Write(plainTextBytes, 0, plainTextBytes.Length);
                }
                byte[] output = ms.ToArray();
                return Convert.ToBase64String(output).Replace('+', '-').Replace('/', '_').Replace("=", "");
            }
        }
    }

    static string Decrypt(string cipherText, string key, string iv, string outputEncoding = "utf8")
    {
        byte[] keyBytes = Encoding.UTF8.GetBytes(key);
        byte[] ivBytes = Encoding.UTF8.GetBytes(iv);
        byte[] cipherTextBytes = Convert.FromBase64String(cipherText);

        using (Aes cipher = Aes.Create())
        {
            cipher.Key = keyBytes;
            cipher.IV = ivBytes;
            cipher.BlockSize = 128;
            cipher.KeySize = 256;
            cipher.Mode = CipherMode.CBC;
            cipher.Padding = PaddingMode.PKCS7;

            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, cipher.CreateDecryptor(), CryptoStreamMode.Write))
                {
                    cs.Write(cipherTextBytes, 0, cipherTextBytes.Length);
                }
                byte[] output = ms.ToArray();
                return Encoding.UTF8.GetString(output);
            }
        }
    }

    static void Main()
    {
        string encrypted = "SORoNS48u0KniiANU3Y9Mw==";
        Console.WriteLine("Encrypted (base64): " + encrypted);
        string decrypted = Decrypt(encrypted, KEY, IV);
        Console.WriteLine("Decrypted: " + decrypted);
    }
}