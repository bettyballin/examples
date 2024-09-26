csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        // Initialize data and cipher
        byte[] data = System.Text.Encoding.UTF8.GetBytes("Hello, World!");
        Aes cipher = Aes.Create();
        cipher.Key = new byte[32]; // Replace with your key
        cipher.IV = new byte[16]; // Replace with your initialization vector

        // Create encryptor
        ICryptoTransform encryptor = cipher.CreateEncryptor(cipher.Key, cipher.IV);

        // Encrypt data
        byte[] output = new byte[encryptor.OutputBlockSize * ((data.Length / encryptor.InputBlockSize) + 1)];
        int len = encryptor.TransformBlock(data, 0, data.Length, output, 0);
        encryptor.TransformFinalBlock(new byte[0], 0, 0);

        Console.WriteLine(System.Text.Encoding.UTF8.GetString(output, 0, len));
    }
}