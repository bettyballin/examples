csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private static string _password = "your_password";
    private static string _salt = "your_salt";

    public static void Main()
    {
        byte[] encryptedData = new byte[] { /* your encrypted data */ };
        byte[] decryptedData = Decrypt(encryptedData);
        Console.WriteLine(BitConverter.ToString(decryptedData));
    }

    public static byte[] Decrypt(byte[] value)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider())
        {
            Rfc2898DeriveBytes key = new Rfc2898DeriveBytes(_password, Encoding.ASCII.GetBytes(_salt));

            aes.Key = key.GetBytes(aes.KeySize / 8);
            aes.Padding = PaddingMode.PKCS7;
            aes.Mode = CipherMode.CBC;

            using (MemoryStream ms = new MemoryStream(value))
            {
                byte[] iv = new byte[aes.IV.Length];

                ms.Read(iv, 0, aes.IV.Length);
                aes.IV = iv;

                using (var crypt = aes.CreateDecryptor(aes.Key, aes.IV))
                using (CryptoStream cs = new CryptoStream(ms, crypt, CryptoStreamMode.Read))
                    return ReadStream(cs, aes.IV.Length, value.Length - aes.IV.Length);
            }
        }
    }

    private static byte[] ReadStream(Stream stream, int offset, int length)
    {
        byte[] buffer = new byte[length];
        stream.Read(buffer, 0, length);
        return buffer;
    }
}