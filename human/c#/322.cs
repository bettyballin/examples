csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        DESCryptoServiceProvider alg = new DESCryptoServiceProvider();
        alg.Mode = CipherMode.ECB;  // specified

        // Create a key and initialization vector
        alg.GenerateKey();
        alg.GenerateIV();

        // Get the key and IV as byte arrays
        byte[] key = alg.Key;
        byte[] iv = alg.IV;

        // Create a string to encrypt
        string plainText = "This is some sample text to encrypt.";

        // Encrypt the string
        byte[] encrypted = EncryptString(alg, plainText);

        // Decrypt the string
        string decrypted = DecryptString(alg, encrypted);

        // Display the results
        Console.WriteLine("Plain text: " + plainText);
        Console.WriteLine("Encrypted text: " + Convert.ToBase64String(encrypted));
        Console.WriteLine("Decrypted text: " + decrypted);
    }

    static byte[] EncryptString(SymmetricAlgorithm alg, string plainText)
    {
        // Create a MemoryStream to hold the encrypted data
        System.IO.MemoryStream ms = new System.IO.MemoryStream();

        // Create a CryptoStream to do the encryption
        CryptoStream cs = new CryptoStream(ms, alg.CreateEncryptor(), CryptoStreamMode.Write);

        // Convert the string to a byte array
        byte[] bytes = Encoding.ASCII.GetBytes(plainText);

        // Write the bytes to the CryptoStream
        cs.Write(bytes, 0, bytes.Length);

        // Close the CryptoStream
        cs.Close();

        // Get the encrypted data from the MemoryStream
        byte[] encrypted = ms.ToArray();

        // Return the encrypted data
        return encrypted;
    }

    static string DecryptString(SymmetricAlgorithm alg, byte[] encrypted)
    {
        // Create a MemoryStream to hold the decrypted data
        System.IO.MemoryStream ms = new System.IO.MemoryStream(encrypted);

        // Create a CryptoStream to do the decryption
        CryptoStream cs = new CryptoStream(ms, alg.CreateDecryptor(), CryptoStreamMode.Read);

        // Create a StreamReader to read the decrypted data
        System.IO.StreamReader sr = new System.IO.StreamReader(cs);

        // Read the decrypted data
        string decrypted = sr.ReadToEnd();

        // Close the StreamReader
        sr.Close();

        // Return the decrypted data
        return decrypted;
    }
}