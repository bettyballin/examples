csharp
using System;
using System.IO;
using System.Security.Cryptography;

public class AesEncryption
{
    public static byte[] Decrypt(byte[] data, Aes aes)
    {
        ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
        using (MemoryStream ms = new MemoryStream(data))
        {
            using (CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read))
            {
                byte[] decrypted = new byte[data.Length];
                cs.Read(decrypted, 0, decrypted.Length);
                return decrypted;
            }
        }
    }
}

class Program
{
    static void Main()
    {
        Aes aes = Aes.Create();
        byte[] encrypted = { /* your encrypted data */ };

        File.WriteAllBytes(@"C:\Users\sepita\Desktop\My.bin", encrypted);

        byte[] decrypted = AesEncryption.Decrypt(File.ReadAllBytes(@"C:\Users\sepita\Desktop\My.bin"), aes);
    }
}