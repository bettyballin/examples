csharp
using System;

class Program
{
    static void Main()
    {
        byte[] magic = new byte[] { 0x45, 0x43, 0xB4, 0x31 };
        byte[] cbKey = new byte[] { 0x20, 0x00, 0x00, 0x00 };
        byte[] xBytes = new byte[] { 0x27, 0x2F, 0x71, 0xC1, 0xD8, 0xB3, 0xDC, 0x0A, 0x7F, 0xCB, 0x1E, 0x96, 0x50, 0xEE, 0xF6, 0x4E, 0xA8, 0xF6, 0x39, 0xBE, 0xC9, 0x7D, 0x49, 0xF8, 0x84, 0x84, 0x55, 0xC2, 0xF5, 0x86, 0x9F, 0x73 };
        byte[] yBytes = new byte[] { 0x27, 0x2F, 0x71, 0xC1, 0xD8, 0xB3, 0xDC, 0x0A, 0x7F, 0xCB, 0x1E, 0x96, 0x50, 0xEE, 0xF6, 0x4E, 0xA8, 0xF6, 0x39, 0xBE, 0xC9, 0x7D, 0x49, 0xF8, 0x84, 0x84, 0x55, 0xC2, 0xF5, 0x86, 0x9F, 0x73 };

        Console.WriteLine(BitConverter.ToString(magic));
        Console.WriteLine(BitConverter.ToString(cbKey));
        Console.WriteLine(BitConverter.ToString(xBytes));
        Console.WriteLine(BitConverter.ToString(yBytes));
    }
}