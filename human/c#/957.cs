csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string plaintext = "The quick brown fox jumps over the lazy dog";
        string iv = "0123456789012345";
        string keyName = "keyName";

        string ciphertext1 = EncryptWithKey(plaintext, keyName, iv);
        Console.WriteLine(ciphertext1);
        string ciphertext2 = EncryptWithKey(plaintext, keyName, iv);
        Console.WriteLine(ciphertext2);
        string decryptedText1 = DecryptWithKey(ciphertext1, keyName, iv);
        Console.WriteLine(decryptedText1);
    }

    static string EncryptWithKey(string plaintext, string keyName, string iv)
    {
        using (Aes aes = Aes.Create())
        {
            aes.Key = GetKey(keyName);
            aes.IV = Encoding.UTF8.GetBytes(iv);
            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
            using (MemoryStream ms = new MemoryStream())
            {
                using (CryptoStream cs = new CryptoStream(ms, encryptor, CryptoStreamMode.Write))
                {
                    using (StreamWriter sw = new StreamWriter(cs))
                    {
                        sw.Write(plaintext);
                    }
                    return Convert.ToBase64String(ms.ToArray());
                }
            }
        }
    }

    static string DecryptWithKey(string ciphertext, string keyName, string iv)
    {
        using (Aes aes = Aes.Create())
        {
            aes.Key = GetKey(keyName);
            aes.IV = Encoding.UTF8.GetBytes(iv);
            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
            using (MemoryStream ms = new MemoryStream(Convert.FromBase64String(ciphertext)))
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

    static byte[] GetKey(string keyName)
    {
        using (SHA256 sha256 = SHA256.Create())
        {
            return sha256.ComputeHash(Encoding.UTF8.GetBytes(keyName));
        }
    }
}