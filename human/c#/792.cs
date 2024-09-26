csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using (ECDiffieHellmanCng ephem = new ECDiffieHellmanCng())
        {
            ECParameters ephemPublicParams = ephem.ExportParameters(false);
            int pointLen = ephemPublicParams.Q.X.Length;
            byte[] rBar = new byte[pointLen * 2 + 1];
            rBar[0] = 0x04;
            Buffer.BlockCopy(ephemPublicParams.Q.X, 0, rBar, 1, pointLen);
            Buffer.BlockCopy(ephemPublicParams.Q.Y, 0, rBar, 1 + pointLen, pointLen);
            Console.WriteLine(BitConverter.ToString(rBar));
        }
    }
}