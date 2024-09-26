csharp
using System;
using System.Net.NetworkInformation;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    private const int IV_SIZE = 16;
    private static readonly byte[] DEFAULT_MAC = new byte[] { 0x00, 0x11, 0x22, 0x33, 0x44, 0x55 };

    public static void Main()
    {
        byte[] iv = GenerateIv1();
        Console.WriteLine(BitConverter.ToString(iv));
    }

    private static byte[] GenerateIv1()
    {
        byte[] iv = new byte[IV_SIZE];
        long time = DateTime.Now.Ticks;
        byte[] mac = null;

        try
        {
            NetworkInterface[] interfaces = NetworkInterface.GetAllNetworkInterfaces();
            for (int i = 0; i < interfaces.Length; i++)
                if (i != NetworkInterface.LoopbackInterfaceIndex)
                {
                    mac = interfaces[i].GetPhysicalAddress().GetAddressBytes();
                    break;
                }
        }
        catch
        {
            //Not much to do, just go with default MAC
        }

        if (mac == null)
            mac = DEFAULT_MAC;

        for (int i = 0; i < 8; i++)
            iv[i] = (byte)((time >> (i * 8)) & 0xff);

        Array.Copy(mac, 0, iv, 8, Math.Min(mac.Length, iv.Length - 8));
        return DigestRandomBytes(iv, 256);
    }

    private static byte[] DigestRandomBytes(byte[] input, int iterations)
    {
        byte[] hash = input;
        for (int i = 0; i < iterations; i++)
        {
            using (SHA256 sha256 = SHA256.Create())
            {
                hash = sha256.ComputeHash(hash);
            }
        }
        return hash;
    }
}