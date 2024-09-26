csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.IO;
using System.Security.Cryptography.X509Certificates;

public class Program
{
    private static string encryptWithKey(string plaintext, string keyName, string iv)
    {
        CngProvider keyStorageProvider = CngProvider.MicrosoftSoftwareKeyStorageProvider;
        if (!CngKey.Exists(keyName, keyStorageProvider))
        {
            CngKeyCreationParameters keyCreationParameters = new CngKeyCreationParameters()
            {
                Provider = keyStorageProvider
            };
            CngKey.Create(new CngAlgorithm("AES"), keyName, keyCreationParameters);
        }
        Aes aes = new AesCng(keyName, keyStorageProvider);
        aes.IV = Encoding.UTF8.GetBytes(iv);

        var encryptor = aes.CreateEncryptor();
        byte[] plaintextBytes = Encoding.UTF8.GetBytes(plaintext);
        byte[] ciphertextBytes = encryptor.TransformFinalBlock(plaintextBytes, 0, plaintextBytes.Length);
        aes.Dispose();

        return Convert.ToBase64String(ciphertextBytes);
    }

    public static void Main()
    {
        string plaintext = "Hello, World!";
        string keyName = "myKey";
        string iv = "myIV";
        string encrypted = encryptWithKey(plaintext, keyName, iv);
        Console.WriteLine(encrypted);
    }
}