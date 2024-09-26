csharp
using System;

class Program
{
    static string Encrypt(string plaintext, int shift)
    {
        string ciphertext = "";
        foreach (char c in plaintext)
        {
            if (char.IsLetter(c))
            {
                int asciiOffset = char.IsUpper(c) ? 65 : 97;
                ciphertext += (char)((c - asciiOffset + shift) % 26 + asciiOffset);
            }
            else
            {
                ciphertext += c;
            }
        }
        return ciphertext;
    }

    static string Decrypt(string ciphertext, int shift)
    {
        return Encrypt(ciphertext, -shift);
    }

    static void Main()
    {
        string plaintext = "Hello, World!";
        int shift = 3;
        string ciphertext = Encrypt(plaintext, shift);
        Console.WriteLine($"Plaintext: {plaintext}");
        Console.WriteLine($"Shift: {shift}");
        Console.WriteLine($"Ciphertext: {ciphertext}");
        Console.WriteLine($"Decrypted: {Decrypt(ciphertext, shift)}");
    }
}