csharp
using System;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

public class AesDecryptor
{
    public byte[] Decrypt(byte[] encrypted, byte[] key, byte[] vector)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider { Key = key, IV = vector })
        using (ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV))
        using (MemoryStream ms = new MemoryStream(encrypted))
        using (CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read))
        {
            var decrypted = new byte[encrypted.Length];
            var bytesRead = cs.Read(decrypted, 0, encrypted.Length);

            return decrypted.Take(bytesRead).ToArray();
        }
    }
}

class Program
{
    static void Main()
    {
        var key = Encoding.UTF8.GetBytes("your_key_here");
        var vector = Encoding.UTF8.GetBytes("your_vector_here");
        var encrypted = Encoding.UTF8.GetBytes("your_encrypted_data_here");

        var decryptor = new AesDecryptor();
        var decrypted = decryptor.Decrypt(encrypted, key, vector);

        Console.WriteLine(Encoding.UTF8.GetString(decrypted));
    }
}