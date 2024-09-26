csharp
using System;
using System.Security.Cryptography;
using System.Linq;

class Program
{
    private static readonly byte[] s_secp256r1Prefix = Convert.FromBase64String("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE");

    private static ECParameters ConvertSecp256r1PublicKeyToECParameters(string base64)
    {
        byte[] subjectPublicKeyInfo = Convert.FromBase64String(base64);

        if (subjectPublicKeyInfo.Length != 91)
            throw new InvalidOperationException();

        byte[] prefix = s_secp256r1Prefix;

        if (!subjectPublicKeyInfo.Take(prefix.Length).SequenceEqual(prefix))
            throw new InvalidOperationException();

        byte[] x = new byte[32];
        byte[] y = new byte[32];
        Buffer.BlockCopy(subjectPublicKeyInfo, prefix.Length, x, 0, x.Length);
        Buffer.BlockCopy(subjectPublicKeyInfo, prefix.Length + x.Length, y, 0, y.Length);

        ECParameters ecParameters = new ECParameters();
        ecParameters.Curve = ECCurve.NamedCurves.nistP256; // aka secp256r1 aka  prime256v1
        ecParameters.Q.X = x;
        ecParameters.Q.Y = y;

        return ecParameters;
    }

    static void Main(string[] args)
    {
        string base64 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEMG8QjJjZ5FyKx6VvkoSTaIbf/4RgU9S0GaGpA37yeg3hK7J0YlP5La6eIY7yWjcroWvFDCVZB1qQxQKnxI1zP1iZg==";
        ECParameters ecParameters = ConvertSecp256r1PublicKeyToECParameters(base64);
        Console.WriteLine(ecParameters.Curve.Name);
        Console.WriteLine(BitConverter.ToString(ecParameters.Q.X));
        Console.WriteLine(BitConverter.ToString(ecParameters.Q.Y));
    }
}