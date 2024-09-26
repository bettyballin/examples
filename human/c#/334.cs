csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var IV = new byte[8];//empty byte array
        var key = new byte[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef };

        var data = Encoding.ASCII.GetBytes("7654321 Now is the time for ");

        DES DESalg = DES.Create();
        DESalg.Mode = CipherMode.CBC;
        DESalg.Padding = PaddingMode.None;
        ICryptoTransform crypt = DESalg.CreateEncryptor(key, IV);

        var result = new byte[8];
        int LoopCount = data.Length / 8;
        for (int i = 0; i < LoopCount; i++)
        {
            Console.WriteLine("=============Round {0}==============", i + 1);
            byte[] part = new byte[8];

            Array.Copy(data, i * 8, part, 0, 8);
            Console.WriteLine("Plain text : {0}", ByteArrayToString(part));
            part = XorArray(part, result);
            Console.WriteLine("DES INPUT  : {0}", ByteArrayToString(part));
            result = EncryptPart(crypt, part);
        }
        int remain = data.Length % 8;
        if (remain != 0)
        {
            Console.WriteLine("===========Final Round==============");
            byte[] LastPart = new byte[8];//
            Array.Copy(data, data.Length - remain, LastPart, 0, remain);
            Console.WriteLine("Plain text : " + ByteArrayToString(LastPart));
            LastPart = XorArray(LastPart, result);
            Console.WriteLine("DES INPUT  : " + ByteArrayToString(LastPart));
            result = EncryptPart(crypt, LastPart);
        }

        Console.WriteLine("Result: {0}", ByteArrayToString(result));
    }

    static byte[] EncryptPart(ICryptoTransform crypt, byte[] part)
    {
        byte[] result = new byte[8];
        crypt.TransformBlock(part, 0, part.Length, result, 0);
        return result;
    }

    static byte[] XorArray(byte[] arr1, byte[] arr2)
    {
        byte[] result = new byte[arr1.Length];
        for (int i = 0; i < arr1.Length; i++)
        {
            result[i] = (byte)(arr1[i] ^ arr2[i]);
        }
        return result;
    }

    static string ByteArrayToString(byte[] arr)
    {
        StringBuilder sb = new StringBuilder();
        foreach (byte b in arr)
        {
            sb.Append(b.ToString("x2"));
        }
        return sb.ToString();
    }
}