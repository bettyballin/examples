csharp
using System;

class Program
{
    static byte[] Encrypt(byte[] data)
    {
        byte[] result = new byte[data.Length];
        for (int i = 0; i < data.Length; i++)
        {
            result[i] = (byte)(data[i] ^ 0x45);
        }
        return result;
    }

    static byte[] Decrypt(byte[] data)
    {
        byte[] result = new byte[data.Length];
        for (int i = 0; i < data.Length; i++)
        {
            result[i] = (byte)(data[i] ^ 0x45);
        }
        return result;
    }

    static void Main(string[] args)
    {
        byte[] original = new byte[] { 0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39 };
        byte[] crypted = new byte[] { 0x76, 0x2B, 0x6D, 0xCE, 0xA9, 0xC2, 0xA7, 0x46, 0x0D, 0xB7 };
        byte[] decrypted = Decrypt(crypted);

        Console.WriteLine("Original: " + BitConverter.ToString(original).Replace("-", ""));
        Console.WriteLine("Crypted: " + BitConverter.ToString(crypted).Replace("-", ""));
        Console.WriteLine("Decrypted: " + BitConverter.ToString(decrypted).Replace("-", ""));
    }
}