csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class HashAlgorithm
{
    public static byte[] HmacMd5(byte[] key, byte[] message)
    {
        using var hmac = new HMACMD5(key);
        return hmac.ComputeHash(message);
    }

    public static byte[] HmacSha1(byte[] key, byte[] message)
    {
        using var hmac = new HMACSHA1(key);
        return hmac.ComputeHash(message);
    }

    public static byte[] HmacSha256(byte[] key, byte[] message)
    {
        using var hmac = new HMACSHA256(key);
        return hmac.ComputeHash(message);
    }

    public static byte[] HmacSha384(byte[] key, byte[] message)
    {
        using var hmac = new HMACSHA384(key);
        return hmac.ComputeHash(message);
    }

    public static byte[] HmacSha512(byte[] key, byte[] message)
    {
        using var hmac = new HMACSHA512(key);
        return hmac.ComputeHash(message);
    }

    public static byte[] AesCmac(byte[] key, byte[] message)
    {
        using var aes = Aes.Create();
        aes.Key = key;
        aes.Mode = CipherMode.CBC;
        aes.Padding = PaddingMode.None;

        using var encryptor = aes.CreateEncryptor();
        var iv = new byte[16];
        var cmac = encryptor.TransformFinalBlock(message, 0, message.Length);

        for (var i = 0; i < iv.Length; i++)
        {
            cmac[i] ^= iv[i];
        }

        return cmac;
    }

    public static void Main()
    {
        var key = Encoding.UTF8.GetBytes("secret_key");
        var message = Encoding.UTF8.GetBytes("Hello, World!");

        Console.WriteLine(BitConverter.ToString(HmacMd5(key, message)));
        Console.WriteLine(BitConverter.ToString(HmacSha1(key, message)));
        Console.WriteLine(BitConverter.ToString(HmacSha256(key, message)));
        Console.WriteLine(BitConverter.ToString(HmacSha384(key, message)));
        Console.WriteLine(BitConverter.ToString(HmacSha512(key, message)));
        Console.WriteLine(BitConverter.ToString(AesCmac(key, message)));
    }
}