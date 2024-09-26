csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.IO;

public class Program
{
    public static void Main()
    {
        byte[] key = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16 };
        byte[] iv = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16 };
        byte[] buff = new byte[] { 0x15, 0x65, 0x70, 0x61, 0x72, 0x69, 0x6e, 0x67, 0x20, 0x66, 0x6f, 0x72, 0x20, 0x64, 0x61, 0x74, 0x61 };

        string decrypted = Decrypt(buff, key, iv);
        Console.WriteLine(decrypted);
    }

    public static string Decrypt(byte[] buff, byte[] key, byte[] iv)
    {
        using (RijndaelManaged rijndael = new RijndaelManaged())
        {
            rijndael.Padding = PaddingMode.PKCS7;
            rijndael.Mode = CipherMode.CBC;
            rijndael.KeySize = 128;
            rijndael.BlockSize = 128;
            ICryptoTransform decryptor = rijndael.CreateDecryptor(key, iv);
            using (MemoryStream memoryStream = new MemoryStream(buff))
            {
                using (CryptoStream cryptoStream = new CryptoStream(memoryStream, decryptor, CryptoStreamMode.Read))
                {
                    byte[] output = new byte[buff.Length];
                    int readBytes = cryptoStream.Read(output, 0, output.Length);
                    return Encoding.UTF8.GetString(output, 0, readBytes);
                }
            }
        }
    }
}