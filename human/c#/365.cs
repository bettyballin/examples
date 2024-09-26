csharp
using System;

class Program
{
    static void Main()
    {
        byte[] encResult = { 1, 2, 3, 4, 5, 6 }; // dummy data
        short[] encShorts = new short[encResult.Length / 2];
        for (int i = 0; i < encShorts.Length; i++)
        {
            encShorts[i] = (short)(encResult[i * 2] * 256 + encResult[i * 2 + 1]);
        }
        foreach (var item in encShorts)
        {
            Console.WriteLine(item);
        }
    }
}