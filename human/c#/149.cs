csharp
using System;

class Program
{
    static void Main()
    {
        byte[] input = { 1, 2, 3, 4 }; // Example input
        int seed = BitConverter.ToInt32(input, 0);
        Random rng = new Random(seed);
        byte[] output = new byte[8];
        Buffer.BlockCopy(input, 0, output, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            output[i] = (byte)rng.Next(256);
        }
        Console.WriteLine(BitConverter.ToString(output));
    }
}