csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private static byte[] _key = Encoding.UTF8.GetBytes("your_key_here");
    private static byte[] _IV = Encoding.UTF8.GetBytes("your_iv_here");

    public static void Main()
    {
        var cipher = Aes.Create();
        var cipherBytes = Encoding.UTF8.GetBytes("your_cipher_text_here");
        byte[] decryptedBytes;

        var dec = cipher.CreateDecryptor(_key, _IV);
        using (var memoryStream = new MemoryStream())
        {
            using (var cryptoStream = new CryptoStream(memoryStream, dec, CryptoStreamMode.Write))
            {
                cryptoStream.Write(cipherBytes, 0, cipherBytes.Length);
            }

            decryptedBytes = memoryStream.ToArray();
        }

        Console.WriteLine(Encoding.UTF8.GetString(decryptedBytes));
    }
}