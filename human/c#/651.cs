csharp
using System;

class Program
{
    static void Main()
    {
        const int NUM_ASC = 256;
        var rng = new Random();
        int ch = 65; // example character code
        int offset = (int)Math.Floor((NUM_ASC + 1) * rng.NextDouble());
        ch = (int)((ch + offset) % NUM_ASC);
        Console.WriteLine(ch);
    }
}