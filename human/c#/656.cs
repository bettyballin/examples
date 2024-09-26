csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private static readonly string _password = "your_password";
    private static readonly string _salt = "your_salt";

    public static void Main()
    {
        byte[] value = Encoding.UTF8.GetBytes("Hello, World!");
        byte[] encrypted = Encrypt(value);
        Console.WriteLine(BitConverter.ToString(encrypted));
    }

    public static byte[] Encrypt(byte[] value)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider())
        {
            Rfc2898DeriveBytes key = new Rfc2898DeriveBytes(_password, Encoding.ASCII.GetBytes(_salt));

            aes.Key = key.GetBytes(aes.KeySize / 8);
            aes.GenerateIV();
            aes.Padding = PaddingMode.PKCS7;
            aes.Mode = CipherMode.CBC;

            using (var crypt = aes.CreateEncryptor(aes.Key, aes.IV))
            using (MemoryStream ms = new MemoryStream())
            {
                ms.Write(aes.IV, 0, aes.IV.Length);
                using (CryptoStream cs = new CryptoStream(ms, crypt, CryptoStreamMode.Write))
                using (BinaryWriter bw = new BinaryWriter(cs))
                {
                    bw.Write(value);
                    cs.FlushFinalBlock();

                    return ms.ToArray();
                }
            }
        }
    }
}