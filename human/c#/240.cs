csharp
using System;
using System.Numerics;

class Program
{
    static void Main()
    {
        BigInteger V45 = new BigInteger(45);
        BigInteger V257 = new BigInteger(257);
        byte[] exp = new byte[256];
        for (int idx = 0; idx < 256; ++idx)
            exp[idx] = (byte)(BigInteger.ModPow(V45, new BigInteger(idx), V257) % 256);
        byte[] log = new byte[256];
        for (int idx = 0; idx < 256; ++idx)
            log[exp[idx]] = (byte)idx;
    }
}