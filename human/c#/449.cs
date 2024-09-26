csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Crypto
{
    private byte[] key;

    public Crypto(string password)
    {
        using (var sha256 = SHA256.Create())
        {
            key = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
        }
    }

    public string EncryptAsBase64(byte[] bytes)
    {
        using (var aes = Aes.Create())
        {
            aes.Key = key;
            aes.GenerateIV();
            var iv = aes.IV;
            using (var encryptor = aes.CreateEncryptor(aes.Key, iv))
            {
                var result = encryptor.TransformFinalBlock(bytes, 0, bytes.Length);
                var combined = new byte[iv.Length + result.Length];
                Array.Copy(iv, 0, combined, 0, iv.Length);
                Array.Copy(result, 0, combined, iv.Length, result.Length);
                return Convert.ToBase64String(combined);
            }
        }
    }
}

public class Program
{
    public static void Main()
    {
        try
        {
            var crypto = new Crypto("MyDifficultPassw");
            var encrypted = crypto.EncryptAsBase64(Encoding.UTF8.GetBytes("tryToEncrypt"));
            Console.WriteLine(encrypted);
        }
        catch (Exception e)
        {
            Console.WriteLine(e.ToString());
        }
    }
}