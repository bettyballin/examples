csharp
using System;

class Program
{
    static void Main()
    {
        int i = 10;
        int keyLengthInBits = 128;
        byte[] key = new byte[keyLengthInBits / 8];

        // Initialize key with some values
        for (int j = 0; j < key.Length; j++)
        {
            key[j] = (byte)j;
        }

        int bit = i & keyLengthInBits;
        int result = (key[bit / 8] >> (bit % 8)) & 1;

        Console.WriteLine(result);
    }
}