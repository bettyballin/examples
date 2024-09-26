csharp
using System;

class Program
{
    static void Main()
    {
        string ECB = "TDEA Electronic Codebook";
        string TCBC = "TDEA Cipher Block Chaining";
        string TCBC_I = "TDEA Cipher Block Chaining - Interleaved";
        string TCFB = "TDEA Cipher Feedback";
        string TCFB_P = "TDEA Cipher Feedback - Pipelined";
        string TOFB = "TDEA Output Feedback";
        string TOFB_I = "TDEA Output Feedback - Interleaved";

        Console.WriteLine(ECB);
        Console.WriteLine(TCBC);
        Console.WriteLine(TCBC_I);
        Console.WriteLine(TCFB);
        Console.WriteLine(TCFB_P);
        Console.WriteLine(TOFB);
        Console.WriteLine(TOFB_I);
    }
}