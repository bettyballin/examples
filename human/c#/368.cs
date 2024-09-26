csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        // assume pre-shared keys are used and set at this point
        byte[] key = Encoding.UTF8.GetBytes("your_secret_key_here");
        byte[] iv = Encoding.UTF8.GetBytes("your_initialization_vector_here");

        AesManaged aes = new AesManaged();
        aes.Key = key;
        aes.IV = iv;

        var aesEncryptor = aes.CreateEncryptor();

        using (FileStream fileStream = File.Create("encrypted_data.bin"))
        {
            CryptoStream aesStream = new CryptoStream(
                fileStream, aesEncryptor, CryptoStreamMode.Write);

            // assume pre-shared keys here too
            byte[] macKey = Encoding.UTF8.GetBytes("your_mac_secret_key_here");
            HMACSHA256 mac = new HMACSHA256(macKey);

            CryptoStream macStream = new CryptoStream(
                aesStream, mac, CryptoStreamMode.Write);

            byte[] data = Encoding.UTF8.GetBytes("Hello, World!");
            macStream.Write(data, 0, data.Length);
        }
    }
}