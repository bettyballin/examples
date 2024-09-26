csharp
using System;
using System.IO;
using System.Security.Cryptography;

class Program
{
    static void Main(string[] args)
    {
        string plaintext = "Hello, World!";
        string cyphertextFile = "cyphertext.txt";
        textToTextEncode(plaintext, cyphertextFile);
    }

    static void textToTextEncode(string plaintext, string cyphertextFile)
    {
        using (StreamWriter writer = new StreamWriter(cyphertextFile))
        {
            foreach (char p in plaintext)
            {
                char c = (char)(p + getNextShift());
                if (c > 'z')
                {
                    c = (char)(c - 26);
                }
                writer.Write(c);
            }
        }
    }

    static int getNextShift()
    {
        using (Aes aes = Aes.Create())
        {
            aes.Mode = CipherMode.CTR;
            ICryptoTransform encryptor = aes.CreateEncryptor();
            byte[] bytes = new byte[1];
            RandomNumberGenerator.Fill(bytes);
            byte b;
            do
            {
                b = encryptor.TransformFinalBlock(bytes, 0, 1)[0];
                b = (byte)(b & 0b00011111);
            }
            while (b >= 26);
            return b;
        }
    }
}