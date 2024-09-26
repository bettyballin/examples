csharp
using System;

class Program
{
    static void Main()
    {
        var cipherInstance = new Cipher();
        string originalText = "Hello, World!";
        string encryptedText = cipherInstance.Cipher(originalText);
        string decryptedText = cipherInstance.DeCipher(encryptedText);

        Console.WriteLine("Original Text: " + originalText);
        Console.WriteLine("Encrypted Text: " + encryptedText);
        Console.WriteLine("Decrypted Text: " + decryptedText);
    }
}

public class Cipher
{
    public string Cipher(string s)
    {
        var array = s.ToCharArray();
        string secret = "asow4akec13";
        int secretLength = secret.Length;
        for (int i = 0; i < s.Length; i++)
        {
            array[i] = (char)(array[i] + secret[i % secretLength]);
        }
        return new string(array);
    }

    public string DeCipher(string s)
    {
        var array = s.ToCharArray();
        string secret = "asow4akec13";
        int secretLength = secret.Length;
        for (int i = 0; i < s.Length; i++)
        {
            array[i] = (char)(array[i] - secret[i % secretLength]);
        }
        return new string(array);
    }
}