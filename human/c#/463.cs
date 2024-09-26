csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // Replace the following with your own keys and IV
        byte[] key = Encoding.UTF8.GetBytes("your_key_here");
        byte[] iv = Encoding.UTF8.GetBytes("your_iv_here");

        using (AesManaged aesManaged = new AesManaged())
        {
            aesManaged.Key = key;
            aesManaged.IV = iv;

            ICryptoTransform decryptor = aesManaged.CreateDecryptor();

            // Example usage:
            byte[] encryptedData = Encoding.UTF8.GetBytes("Hello, World!");
            byte[] decryptedData = decryptor.TransformFinalBlock(encryptedData, 0, encryptedData.Length);

            Console.WriteLine(Encoding.UTF8.GetString(decryptedData));
        }
    }
}