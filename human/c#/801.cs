csharp
using System;

class Program
{
    static void Main()
    {
        // Define the IV and Media Sequence Number values
        byte[] iv = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        uint mediaSequenceNumber = 12345678;

        // Print the IV and Media Sequence Number values
        Console.WriteLine("IV: [" + string.Join(", ", iv) + "]");
        Console.WriteLine($"Media Sequence Number: {mediaSequenceNumber}");
    }
}