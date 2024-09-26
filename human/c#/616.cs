csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // Replace with your private key and initialization vector
        byte[] privateKey = Encoding.UTF8.GetBytes("your_private_key_here");
        byte[] iv = Encoding.UTF8.GetBytes("your_iv_here");

        using (Rijndael rijndael = Rijndael.Create())
        {
            ICryptoTransform decryptor = rijndael.CreateDecryptor(privateKey, iv);

            // Example usage:
            byte[] encryptedData = Encoding.UTF8.GetBytes("your_encrypted_data_here");
            byte[] decryptedData = decryptor.TransformFinalBlock(encryptedData, 0, encryptedData.Length);

            Console.WriteLine(Encoding.UTF8.GetString(decryptedData));
        }
    }
}