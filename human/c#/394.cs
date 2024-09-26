csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private static string Encrypt(string plainText, string passPhrase, string saltValue, string hashAlgorithm, int passwordIterations, string initVector, int keySize)
    {
        var initVectorBytes = Encoding.ASCII.GetBytes(initVector);
        var saltValueBytes = Encoding.ASCII.GetBytes(saltValue);
        var plainTextBytes = Encoding.UTF8.GetBytes(plainText);

        var password = new PasswordDeriveBytes(passPhrase, saltValueBytes, hashAlgorithm, passwordIterations);
        var keyBytes = password.GetBytes(keySize / 8);

        var symmetricKey = new RijndaelManaged { Mode = CipherMode.CBC };
        var encryptor = symmetricKey.CreateEncryptor(keyBytes, initVectorBytes);

        var memoryStream = new MemoryStream();
        var cryptoStream = new CryptoStream(memoryStream, encryptor, CryptoStreamMode.Write);
        cryptoStream.Write(plainTextBytes, 0, plainTextBytes.Length);
        cryptoStream.FlushFinalBlock();

        var cipherTextBytes = memoryStream.ToArray();
        memoryStream.Close();
        cryptoStream.Close();

        var cipherText = Convert.ToBase64String(cipherTextBytes);
        return cipherText;
    }

    private static string Decrypt(string cipherText, string passPhrase, string saltValue, string hashAlgorithm, int passwordIterations, string initVector, int keySize)
    {
        var initVectorBytes = Encoding.ASCII.GetBytes(initVector);
        var saltValueBytes = Encoding.ASCII.GetBytes(saltValue);
        var cipherTextBytes = Convert.FromBase64String(cipherText);

        var password = new PasswordDeriveBytes(passPhrase, saltValueBytes, hashAlgorithm, passwordIterations);
        var keyBytes = password.GetBytes(keySize / 8);

        var symmetricKey = new RijndaelManaged { Mode = CipherMode.CBC };
        var decryptor = symmetricKey.CreateDecryptor(keyBytes, initVectorBytes);

        var memoryStream = new MemoryStream(cipherTextBytes);
        var cryptoStream = new CryptoStream(memoryStream, decryptor, CryptoStreamMode.Read);
        var plainTextBytes = new byte[cipherTextBytes.Length];
        var decryptedByteCount = cryptoStream.Read(plainTextBytes, 0, plainTextBytes.Length);

        memoryStream.Close();
        cryptoStream.Close();

        var plainText = Encoding.UTF8.GetString(plainTextBytes, 0, decryptedByteCount);
        return plainText;
    }

    public static string EncryptData(string encryptText, string passPhrase, string saltValue, string hashAlgorithm, int passwordIterations, string initVector, int keySize)
    {
        return Encrypt(encryptText, passPhrase, saltValue, hashAlgorithm, passwordIterations, initVector, keySize);
    }

    public static string DecryptData(string decryptText, string passPhrase, string saltValue, string hashAlgorithm, int passwordIterations, string initVector, int keySize)
    {
        return Decrypt(decryptText, passPhrase, saltValue, hashAlgorithm, passwordIterations, initVector, keySize);
    }

    public static void Main()
    {
        string text = "Hello, World!";
        string passPhrase = "password";
        string saltValue = "salt";
        string hashAlgorithm = "SHA1";
        int passwordIterations = 1;
        string initVector = "1234567890abcdef";
        int keySize = 256;

        string encryptedText = EncryptData(text, passPhrase, saltValue, hashAlgorithm, passwordIterations, initVector, keySize);
        string decryptedText = DecryptData(encryptedText, passPhrase, saltValue, hashAlgorithm, passwordIterations, initVector, keySize);

        Console.WriteLine($"Original Text: {text}");
        Console.WriteLine($"Encrypted Text: {encryptedText}");
        Console.WriteLine($"Decrypted Text: {decryptedText}");
    }
}


This executable code includes the original encryption and decryption methods, along with `Main` method which demonstrates the usage of `EncryptData` and `DecryptData` methods.