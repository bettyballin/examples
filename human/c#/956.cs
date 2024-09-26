csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string ciphertext = "your_base64_encoded_ciphertext";
        string keyName = "your_key_name";
        string iv = "your_initialization_vector";

        try
        {
            string plaintext = decryptWithKey(ciphertext, keyName, iv);
            Console.WriteLine(plaintext);
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
    }

    private static string decryptWithKey(string ciphertext, string keyName, string iv)
    {
        CngProvider keyStorageProvider = CngProvider.MicrosoftSoftwareKeyStorageProvider;
        if (!CngKey.Exists(keyName, keyStorageProvider))
        {
            throw new Exception("Error: key doesn't exist...");
        }
        Aes aes = new AesCng(keyName, keyStorageProvider);
        aes.IV = Encoding.UTF8.GetBytes(iv);

        var decryptor = aes.CreateDecryptor();
        byte[] ciphertextBytes = Convert.FromBase64String(ciphertext);
        byte[] plaintextBytes = decryptor.TransformFinalBlock(ciphertextBytes, 0, ciphertextBytes.Length);
        aes.Dispose();

        return Encoding.UTF8.GetString(plaintextBytes);
    }
}