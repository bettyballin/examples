csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Encr
{
    public static string DecryptStringAES(string cipherText)
    {
        var keybytes = Encoding.UTF8.GetBytes("4512631236589784");
        var iv = Encoding.UTF8.GetBytes("4512631236589784");

        var encrypted = Convert.FromBase64String(cipherText);
        var decriptedFromJavascript = DecryptStringFromBytes(encrypted, keybytes, iv);
        return decriptedFromJavascript;
    }

    private static string DecryptStringFromBytes(byte[] cipherText, byte[] key, byte[] iv)
    {
        if (cipherText == null || cipherText.Length <= 0)
        {
            throw new ArgumentNullException("cipherText");
        }
        if (key == null || key.Length <= 0)
        {
            throw new ArgumentNullException("key");
        }
        if (iv == null || iv.Length <= 0)
        {
            throw new ArgumentNullException("key");
        }

        string plaintext = null;

        using (var rijAlg = Aes.Create())
        {
            rijAlg.Mode = CipherMode.CBC;
            rijAlg.Padding = PaddingMode.PKCS7;
            rijAlg.KeySize = 128;
            rijAlg.BlockSize = 128;

            rijAlg.Key = key;
            rijAlg.IV = iv;

            var decryptor = rijAlg.CreateDecryptor(rijAlg.Key, rijAlg.IV);

            try
            {
                using (var msDecrypt = new MemoryStream(cipherText))
                {
                    using (var csDecrypt = new CryptoStream(msDecrypt, decryptor, CryptoStreamMode.Read))
                    {
                        using (var srDecrypt = new StreamReader(csDecrypt))
                        {
                            plaintext = srDecrypt.ReadToEnd();
                        }
                    }
                }
            }
            catch
            {
                plaintext = "keyError";
            }
        }

        return plaintext;
    }

    public static string EncryptStringAES(string plainText)
    {
        var keybytes = Encoding.UTF8.GetBytes("4512631236589784");
        var iv = Encoding.UTF8.GetBytes("4512631236589784");

        var encryoFromJavascript = EncryptStringToBytes(plainText, keybytes, iv);
        return Convert.ToBase64String(encryoFromJavascript);
    }

    private static byte[] EncryptStringToBytes(string plainText, byte[] key, byte[] iv)
    {
        if (plainText == null || plainText.Length <= 0)
        {
            throw new ArgumentNullException("plainText");
        }
        if (key == null || key.Length <= 0)
        {
            throw new ArgumentNullException("key");
        }
        if (iv == null || iv.Length <= 0)
        {
            throw new ArgumentNullException("key");
        }

        byte[] encrypted;

        using (var rijAlg = Aes.Create())
        {
            rijAlg.Mode = CipherMode.CBC;
            rijAlg.Padding = PaddingMode.PKCS7;
            rijAlg.KeySize = 128;
            rijAlg.BlockSize = 128;

            rijAlg.Key = key;
            rijAlg.IV = iv;

            var encryptor = rijAlg.CreateEncryptor(rijAlg.Key, rijAlg.IV);

            using (var msEncrypt = new MemoryStream())
            {
                using (var csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))
                {
                    using (var swEncrypt = new StreamWriter(csEncrypt))
                    {
                        swEncrypt.Write(plainText);
                    }
                    encrypted = msEncrypt.ToArray();
                }
            }
        }

        return encrypted;
    }

    public static void Main(string[] args)
    {
        string plainText = "Hello, World!";
        string cipherText = EncryptStringAES(plainText);
        Console.WriteLine("Encrypted: " + cipherText);

        string decryptedText = DecryptStringAES(cipherText);
        Console.WriteLine("Decrypted: " + decryptedText);
    }
}