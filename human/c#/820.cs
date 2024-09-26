csharp
using System;
using System.Security.Cryptography;

public class Program
{
    private static byte[] s_integerZero = new byte[] { 0x02, 0x01, 0x00 };
    private static byte[] s_rsaAlgorithmId = new byte[] { 0x30, 0x0d, 0x06, 0x09, 0x2a, 0x86, 0x48, 0x86, 0xf7, 0x0d, 0x01, 0x01, 0x01, 0x05, 0x00 };

    public static void Main()
    {
        using (RSA rsa = RSA.Create())
        {
            byte[] privateKeyInfo = ExportPrivateKeyInfo(rsa);
            Console.WriteLine(BitConverter.ToString(privateKeyInfo));
        }
    }

    private static byte[] MakeOctetString(byte[] data)
    {
        return MakeTagLengthValue(0x04, data);
    }

    private static byte[] MakeSequence(params byte[][] values)
    {
        int totalLength = 0;
        foreach (byte[] value in values)
        {
            totalLength += value.Length;
        }

        byte[] result = new byte[totalLength + 2];
        result[0] = 0x30;
        result[1] = (byte)totalLength;

        int offset = 2;
        foreach (byte[] value in values)
        {
            Array.Copy(value, 0, result, offset, value.Length);
            offset += value.Length;
        }

        return result;
    }

    private static byte[] MakeInteger(byte[] data)
    {
        byte[] result = new byte[data.Length + 2];
        result[0] = 0x02;
        result[1] = (byte)data.Length;

        Array.Copy(data, 0, result, 2, data.Length);

        return result;
    }

    private static byte[] MakeTagLengthValue(byte tag, byte[] data)
    {
        byte[] result = new byte[data.Length + 2];
        result[0] = tag;
        result[1] = (byte)data.Length;

        Array.Copy(data, 0, result, 2, data.Length);

        return result;
    }

    private static byte[] ExportPrivateKeyInfo(RSA rsa)
    {
        RSAParameters parameters = rsa.ExportParameters(true);

        return MakeSequence(
            s_integerZero,
            s_rsaAlgorithmId,
            MakeOctetString(
                MakeSequence(
                    s_integerZero,
                    MakeInteger(parameters.Modulus),
                    MakeInteger(parameters.Exponent),
                    MakeInteger(parameters.D),
                    MakeInteger(parameters.P),
                    MakeInteger(parameters.Q),
                    MakeInteger(parameters.DP),
                    MakeInteger(parameters.DQ),
                    MakeInteger(parameters.InverseQ))));
    }
}