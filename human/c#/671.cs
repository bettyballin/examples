csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private static int BlockSize = 64;

    public static byte[] HMAC(byte[] message)
    {
        byte[] key = { 0x0a, 0x7c, 0x7e, 0x52 };
        if (key.Length > BlockSize)
        {
            key = GetMD5Hash(key);
        }
        byte[] paddedKey = new byte[BlockSize];
        key.CopyTo(paddedKey, BlockSize - key.Length);

        byte[] o_key_pad = new byte[BlockSize];
        byte[] i_key_pad = new byte[BlockSize];
        for (int i = 0; i < BlockSize; i++)
        {
            o_key_pad[i] = (byte)(0x5c ^ paddedKey[i]);
            i_key_pad[i] = (byte)(0x36 ^ paddedKey[i]);
        }

        byte[] inner_hash = GetMD5Hash(concat(i_key_pad, message));
        return GetMD5Hash(concat(o_key_pad, inner_hash));
    }

    private static byte[] concat(byte[] a1, byte[] a2)
    {
        byte[] res = new byte[a1.Length + a2.Length];
        a1.CopyTo(res, 0);
        a2.CopyTo(res, a1.Length);
        return res;
    }

    private static byte[] GetMD5Hash(byte[] ToHash)
    {
        using (MD5 md5 = MD5.Create())
        {
            return md5.ComputeHash(ToHash);
        }
    }

    public static void Main()
    {
        byte[] message = Encoding.UTF8.GetBytes("Hello, World!");
        byte[] hmac = HMAC(message);
        Console.WriteLine(BitConverter.ToString(hmac));
    }
}