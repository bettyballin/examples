csharp
using System;
using System.Security.Cryptography;
using System.Threading;

public static class BetterRandom
{
    private static readonly ThreadLocal<RandomNumberGenerator> crng = new ThreadLocal<RandomNumberGenerator>(RandomNumberGenerator.Create);
    private static readonly ThreadLocal<byte[]> bytes = new ThreadLocal<byte[]>(() => new byte[sizeof(int)]);

    public static int NextInt()
    {
        crng.Value.GetBytes(bytes.Value);
        return BitConverter.ToInt32(bytes.Value, 0) & int.MaxValue;
    }

    public static double NextDouble()
    {
        while (true)
        {
            long x = (long)NextInt() & 0x001FFFFF;
            x <<= 31;
            x |= (long)NextInt();
            double n = x;
            const double d = 1L << 52;
            double q = n / d;
            if (q != 1.0)
                return q;
        }
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(BetterRandom.NextInt());
        Console.WriteLine(BetterRandom.NextDouble());
    }
}