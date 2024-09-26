csharp
using System;
using System.Runtime.InteropServices;

[StructLayout(LayoutKind.Sequential)]
public struct ECPrivateKey
{
    public int version;
    public byte[] privateKey;
    public ECParameters? parameters;
    public byte[]? publicKey;
}

[StructLayout(LayoutKind.Sequential)]
public struct ECParameters
{
    public NamedCurve namedCurve;
}

public enum NamedCurve : int
{
    // Add named curves here
}

public class Program
{
    public static void Main()
    {
        ECPrivateKey privateKey = new ECPrivateKey
        {
            version = 1,
            privateKey = new byte[] { 0x01, 0x02, 0x03 },
            parameters = new ECParameters
            {
                namedCurve = NamedCurve.secp256r1
            },
            publicKey = new byte[] { 0x04, 0x05, 0x06 }
        };

        Console.WriteLine(privateKey.version);
        Console.WriteLine(BitConverter.ToString(privateKey.privateKey));
        Console.WriteLine(privateKey.parameters?.namedCurve.ToString());
        Console.WriteLine(BitConverter.ToString(privateKey.publicKey));
    }
}