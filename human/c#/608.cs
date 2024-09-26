csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using System.Xml.Serialization;

public class Credentials
{
    public string Email { get; set; }
    public string Password { get; set; }
}

public class AES
{
    public static byte[] AES_Encrypt(byte[] bytesToBeEncrypted, byte[] passwordBytes)
    {
        byte[] encryptedBytes = null;

        using (MemoryStream ms = new MemoryStream())
        {
            using (Aes encryptor = Aes.Create())
            {
                encryptor.Key = passwordBytes;
                encryptor.GenerateIV();
                ms.Write(encryptor.IV, 0, encryptor.IV.Length);
                using (CryptoStream cs = new CryptoStream(ms, encryptor.CreateEncryptor(), CryptoStreamMode.Write))
                {
                    cs.Write(bytesToBeEncrypted, 0, bytesToBeEncrypted.Length);
                }
                encryptedBytes = ms.ToArray();
            }
        }

        return encryptedBytes;
    }
}

class Program
{
    static void Main()
    {
        XmlSerializer xs = new XmlSerializer(typeof(Credentials));
        MemoryStream ms = new MemoryStream();
        xs.Serialize(ms, new Credentials() { Email = "email@service.com", Password = "passworduser" });
        byte[] encrypted = AES.AES_Encrypt(ms.ToArray(), Encoding.UTF8.GetBytes("encryptionkey")); 
        File.WriteAllBytes("passwordfile.pwd", encrypted);
    }
}