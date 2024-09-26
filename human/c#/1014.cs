csharp
using System;
using System.Text;
using System.Security.Cryptography;
using System.IO;

public class Program
{
    public static void Main()
    {
        var str = Encrypt("test", "KFmnMAPzP!g@6Dy5HD?JSgYC9obE&m@m");
        Console.WriteLine("Encrypted: " + str);
        Console.WriteLine("Decrypted: " + Decrypt(str, "KFmnMAPzP!g@6Dy5HD?JSgYC9obE&m@m"));
    }

    public static string Encrypt(string data, string key)
    {
        string IV = key.Substring(0, 16);
        byte[] iv = Encoding.UTF8.GetBytes(IV);
        byte[] array;
        using (Aes aes = Aes.Create())
        {
            aes.Key = Encoding.UTF8.GetBytes(key);
            aes.IV = iv;
            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
            using (MemoryStream memoryStream = new MemoryStream())
            {
                using (CryptoStream cryptoStream = new CryptoStream((Stream)memoryStream, encryptor, CryptoStreamMode.Write))
                {
                    using (StreamWriter streamWriter = new StreamWriter((Stream)cryptoStream))
                    {
                        streamWriter.Write(data);
                    }
                    array = memoryStream.ToArray();
                }
            }
        }
        return Convert.ToBase64String(array);
    }

    public static string Decrypt(string data, string key)
    {
        string IV = key.Substring(0, 16);
        byte[] iv = Encoding.UTF8.GetBytes(IV);
        byte[] buffer = Convert.FromBase64String(data);
        using (Aes aes = Aes.Create())
        {
            aes.Key = Encoding.UTF8.GetBytes(key);
            aes.IV = iv;
            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
            using (MemoryStream memoryStream = new MemoryStream(buffer))
            {
                using (CryptoStream cryptoStream = new CryptoStream((Stream)memoryStream, decryptor, CryptoStreamMode.Read))
                {
                    using (StreamReader streamReader = new StreamReader((Stream)cryptoStream))
                    {
                        return streamReader.ReadToEnd();
                    }
                }
            }
        }
    }
}