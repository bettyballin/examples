csharp
using System;
using System.Numerics;

public class Definition
{
    public uint Initializer { get; set; }
    public uint TruncatedPolynomial { get; set; }
    public uint FinalXorValue { get; set; }
    public bool ReverseResultBeforeFinalXor { get; set; }
    public bool ReverseDataBytes { get; set; }
}

public class CRC32
{
    private readonly Definition _definition;

    public CRC32(Definition definition)
    {
        _definition = definition;
    }

    public byte[] ComputeHash(byte[] input)
    {
        uint crc = _definition.Initializer;
        foreach (byte b in input)
        {
            crc ^= Reverse((uint)b);
            for (int i = 0; i < 8; i++)
            {
                if ((crc & 1) != 0)
                {
                    crc = (crc >> 1) ^ _definition.TruncatedPolynomial;
                }
                else
                {
                    crc >>= 1;
                }
            }
        }
        crc = _definition.ReverseResultBeforeFinalXor ? Reverse(crc) : crc;
        crc ^= _definition.FinalXorValue;
        return BitConverter.GetBytes(crc);
    }

    private uint Reverse(uint input)
    {
        uint output = 0;
        for (int i = 0; i < 8; i++)
        {
            output = (output << 1) | (input & 1);
            input >>= 1;
        }
        return output;
    }
}

public class Program
{
    public static void Main()
    {
        var definition = new Definition
        {
            Initializer = 0xFFFFFFFF,
            TruncatedPolynomial = 0x04C11DB7,
            FinalXorValue = 0x00000000,
            ReverseResultBeforeFinalXor = true,
            ReverseDataBytes = true
        };

        var inputHex = "3D020000000F0000112233445566778899AABBCCDDEEFF";
        var input = Convert.FromHexString(inputHex);
        var crc32 = new CRC32(definition);

        var hash = crc32.ComputeHash(input);
        var crc32Hex = Convert.ToHexString(hash);
        Console.WriteLine(crc32Hex);
    }
}