csharp
using Org.BouncyCastle.Asn1.X9;
using Org.BouncyCastle.Crypto.EC;
using Org.BouncyCastle.Math.EC;
using System;

class Program
{
    static void Main()
    {
        byte[] data = Convert.FromHexString("0388bdeaa6e3e7293ae41f385e33a7c4a8f504a1f44e9b44e2e0d2073e6f24d");
        byte[] raw = ConvertToRaw(data);
        Console.WriteLine(BitConverter.ToString(raw));
    }

    private static byte[] ConvertToRaw(byte[] data)
    {
        if (data[0] != 4)
        {
            X9ECParameters curve = CustomNamedCurves.GetByName("secp256r1");
            ECPoint point = curve.Curve.DecodePoint(data).Normalize();
            data = point.GetEncoded(false);
        }
        return data[1..];
    }
}