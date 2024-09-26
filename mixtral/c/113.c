This is not C code, it's C# code. Here is the corrected and executable version:

sharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.IO;

public class Program
{
    public static void Main()
    {
        byte[] key = new byte[32]; // 256-bit AES

        using (Aes aesAlg = Aes.Create())
        {
            aesAlg.Key = key;
            aesAlg.KeySize = 256;

            aesAlg.Padding = PaddingMode.None;

            byte[] plaintextBytes = Encoding.UTF8.GetBytes("Your Plain Text");

            using (MemoryStream msEncrypt = new MemoryStream())
            {
                ICryptoTransform encryptor = aesAlg.CreateEncryptor();

                using (CryptoStream csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))
                {
                    // Write all data to the stream
                    csEncrypt.Write(plaintextBytes, 0, plaintextBytes.Length);
                }

                byte[] cipherTextBytes = msEncrypt.ToArray();

                Console.WriteLine(BitConverter.ToString(cipherTextBytes));
            }
        }
    }
}