csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    const string key = "xxxxxxxxxxxxxxxx";
    const string msg = "yM377gXxX5Du71hgkPH+Fg==";

    static void Main()
    {
        byte[] encryptedBytes = Convert.FromBase64String(msg);
        byte[] keyBytes = Encoding.UTF8.GetBytes(key);

        using (Aes aes = Aes.Create())
        {
            aes.Key = keyBytes;
            aes.Mode = CipherMode.ECB;
            aes.Padding = PaddingMode.PKCS7;

            ICryptoTransform decryptor = aes.CreateDecryptor();
            byte[] decryptedBytes = decryptor.TransformFinalBlock(encryptedBytes, 0, encryptedBytes.Length);

            string decrypted = Encoding.UTF8.GetString(decryptedBytes);
            Console.WriteLine(decrypted);
        }
    }
}