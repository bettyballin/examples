csharp
using System;

class Program
{
    static void Main()
    {
        byte[] hashBytes = new byte[20]; // Replace with your actual hash bytes
        Random rand = new Random();
        rand.NextBytes(hashBytes);

        int offset = hashBytes[19] & 0xf;
        int binaryCode = (hashBytes[offset] & 0x7f) << 24
            | (hashBytes[offset + 1] & 0xff) << 16
            | (hashBytes[offset + 2] & 0xff) << 8
            | (hashBytes[offset + 3] & 0xff);

        int otp = binaryCode % (int)Math.Pow(10, 6);

        Console.WriteLine(otp.ToString().PadLeft(6, '0'));
    }
}