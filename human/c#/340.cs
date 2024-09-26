csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string vParameter = "Lq4aURUiyvKvEZBWMWpUr2wRSMu96E+J1UeHLTOhKEM=";
        byte[] encryptedV = Convert.FromBase64String(vParameter);
        string salt = "jkjkyt4";
        string password = "^hjkh673!v@!a89mz+%5rT";
        string appIV = "SampleIV12345678";

        byte[] key = SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(salt + password));
        byte[] key16 = new byte[16];
        Array.Copy(key, 2, key16, 0, 16);

        Aes aes = Aes.Create();
        aes.Key = key16;
        aes.IV = Encoding.UTF8.GetBytes(appIV);
        aes.Mode = CipherMode.CBC;
        aes.Padding = PaddingMode.PKCS7;

        ICryptoTransform decryptor = aes.CreateDecryptor();
        byte[] decryptedV = decryptor.TransformFinalBlock(encryptedV, 0, encryptedV.Length);
        string v = Encoding.UTF8.GetString(decryptedV);

        Console.WriteLine(v);
    }
}