csharp
using System;

public class Program
{
    public static void Main()
    {
        var crc32Config = new Crc32Config
        {
            Initializer = 0xFFFFFFFF,
            TruncatedPolynomial = 0x04C11DB7,
            FinalXorValue = 0x00000000,
            ReverseResultBeforeFinalXor = true,
            ReverseDataBytes = true
        };

        Console.WriteLine($"Initializer: {crc32Config.Initializer:X8}");
        Console.WriteLine($"TruncatedPolynomial: {crc32Config.TruncatedPolynomial:X8}");
        Console.WriteLine($"FinalXorValue: {crc32Config.FinalXorValue:X8}");
        Console.WriteLine($"ReverseResultBeforeFinalXor: {crc32Config.ReverseResultBeforeFinalXor}");
        Console.WriteLine($"ReverseDataBytes: {crc32Config.ReverseDataBytes}");
    }
}

public class Crc32Config
{
    public uint Initializer { get; set; }
    public uint TruncatedPolynomial { get; set; }
    public uint FinalXorValue { get; set; }
    public bool ReverseResultBeforeFinalXor { get; set; }
    public bool ReverseDataBytes { get; set; }
}