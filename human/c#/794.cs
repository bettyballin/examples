csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] message = Encoding.UTF8.GetBytes("Hello, World!");
        byte[] ek = new byte[32]; // Replace with your encryption key

        byte[] em;

        // ECIES uses AES with the all zero IV. Since the key is never reused,
        // there's not risk in that.
        using (Aes aes = Aes.Create())
        using (ICryptoTransform encryptor = aes.CreateEncryptor(ek, new byte[16]))
        {
            if (!encryptor.CanTransformMultipleBlocks)
            {
                throw new InvalidOperationException();
            }

            em = encryptor.TransformFinalBlock(message, 0, message.Length);
        }

        Console.WriteLine(BitConverter.ToString(em));
    }
}