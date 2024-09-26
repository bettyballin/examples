csharp
using System;

class Program
{
    static void Main()
    {
        var key = new byte[] { 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11 };
        Console.WriteLine(BitConverter.ToString(key));
    }
}