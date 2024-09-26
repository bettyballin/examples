csharp
using System;
using System.Text;
using System.IO;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        // Replace with your own encrypted data
        byte[] encrypted = Convert.FromBase64String("your_base64_encrypted_string");

        // Replace with your own key and iv
        byte[] key = Encoding.UTF8.GetBytes("your_key_here");
        byte[] iv = Encoding.UTF8.GetBytes("your_iv_here");

        // Create a new Aes object
        Aes aes = Aes.Create();

        // Configure the Aes object
        aes.Key = key;
        aes.IV = iv;

        // Create a decryptor
        ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);

        // Create the streams used for decryption.
        MemoryStream ms = new MemoryStream(encrypted);
        CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read);
        StreamReader sr = new StreamReader(cs);

        // Read the decrypted bytes from the decrypting stream
        byte[] decrypted = Encoding.UTF8.GetBytes(sr.ReadToEnd());

        // Print the decrypted string
        Console.WriteLine("Output: " + Encoding.UTF8.GetString(decrypted));
    }
}