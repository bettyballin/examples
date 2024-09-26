csharp
using System;
using System.Security.Cryptography;

public class Program
{
    public static void Main(string[] args)
    {
        byte[] rawXY = new byte[64]; // Replace with your raw key bytes
        using (var publicKey = GetPublicKeyFromBytes(rawXY))
        {
            Console.WriteLine(publicKey.ToString());
        }
    }

    private static System.Security.Cryptography.ECDsa GetPublicKeyFromBytes(byte[] rawXY)
    {
        int size = rawXY.Length / 2;
        var x = new byte[size];
        var y = new byte[size];
        Array.Copy(rawXY, 0, x, 0, size);
        Array.Copy(rawXY, size, y, 0, size);

        using (var ecDsa = ECDsa.Create(ECCurve.CreateFromFriendlyName("secP256r1")))
        {
            var point = new ECPoint
            {
                X = x,
                Y = y
            };
            var parameters = new ECParameters
            {
                Curve = ECCurve.CreateFromFriendlyName("secP256r1"),
                Q = point
            };
            ecDsa.ImportParameters(parameters);
            return ecDsa;
        }
    }
}