csharp
using System;
using System.Text;

public class Program
{
    public static string Encrypt(string text)
    {
        byte[] decryptedBytes = Encoding.UTF8.GetBytes(text);
        return Convert.ToBase64String(decryptedBytes);
    }

    public static string Decrypt(string text)
    {
        byte[] decryptedBytes = Convert.FromBase64String(text);
        return Encoding.UTF8.GetString(decryptedBytes);
    }

    public static void Main()
    {
        string originalText = "Hello, World!";
        string encryptedText = Encrypt(originalText);
        string decryptedText = Decrypt(encryptedText);

        Console.WriteLine("Original Text: " + originalText);
        Console.WriteLine("Encrypted Text: " + encryptedText);
        Console.WriteLine("Decrypted Text: " + decryptedText);
    }
}