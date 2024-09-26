csharp
using System;

class LSTR
{
    int GetSeed()
    {
        return Environment.TickCount & Int32.MaxValue;
    }

    int Lfsr1()
    {
        int start_state = GetSeed();
        int lfsr = start_state;
        int bit;

        bit = ((lfsr >> 0) ^ (lfsr >> 2) ^ (lfsr >> 3) ^ (lfsr >> 5)) & 1;
        lfsr = (lfsr >> 1) | (bit << 15);

        return lfsr;
    }

    static void Main(string[] args)
    {
        LSTR lstr = new LSTR();
        Console.WriteLine(lstr.Lfsr1());
    }
}