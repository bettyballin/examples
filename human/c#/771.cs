csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Fnv1_32 : HashAlgorithm
{
    private const uint FnvPrime = 0x811C9DC5;
    private const uint FnvOffsetBasis = 0x811C9DC5;

    private uint hash;

    public Fnv1_32()
    {
        hash = FnvOffsetBasis;
    }

    public override void Initialize()
    {
        hash = FnvOffsetBasis;
    }

    protected override void HashCore(byte[] array, int ibStart, int cbSize)
    {
        for (int i = ibStart; i < cbSize + ibStart; i++)
        {
            hash = (hash ^ array[i]) * FnvPrime;
        }
    }

    protected override byte[] HashFinal()
    {
        byte[] hashBytes = BitConverter.GetBytes(hash);
        if (BitConverter.IsLittleEndian)
        {
            Array.Reverse(hashBytes);
        }
        return hashBytes;
    }
}

public class HMACFnv1_32 : HMAC
{
    private const string Fnv1CryptoConfigId = "Fnv1_32";

    static HMACFnv1_32()
    {
        CryptoConfig.AddAlgorithm(typeof(Fnv1_32), Fnv1CryptoConfigId);
    }

    public HMACFnv1_32(byte[] key)
    {
        HashName = Fnv1CryptoConfigId;
        HashSizeValue = 32;
        Key = key;
    }
}

class Program
{
    static void Main()
    {
        byte[] key = Encoding.UTF8.GetBytes("myKey");
        HMACFnv1_32 hmac = new HMACFnv1_32(key);
        byte[] data = Encoding.UTF8.GetBytes("Hello, World!");
        byte[] hash = hmac.ComputeHash(data);
        Console.WriteLine(BitConverter.ToString(hash));
    }
}