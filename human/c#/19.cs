csharp
using System;

public enum ALG_ID : uint
{
    // Add your algorithm IDs here
}

[StructLayout(LayoutKind.Sequential)]
public struct MyStruct
{
    public byte bType;
    public byte bVersion;
    public ushort reserved;
    public ALG_ID aiKeyAlg;
}

class Program
{
    static void Main()
    {
        MyStruct myStruct = new MyStruct
        {
            bType = 0x01,
            bVersion = 0x02,
            reserved = 0x0003,
            aiKeyAlg = ALG_ID algId = 0x00000004 // Replace with a valid ALG_ID value
        };

        Console.WriteLine("bType: {0:X2}", myStruct.bType);
        Console.WriteLine("bVersion: {0:X2}", myStruct.bVersion);
        Console.WriteLine("reserved: {0:X4}", myStruct.reserved);
        Console.WriteLine("aiKeyAlg: {0:X8}", (uint)myStruct.aiKeyAlg);
    }
}