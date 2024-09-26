csharp
using System;

class Program
{
    static byte[] Pad(byte[] input)
    {
        // Alternatively use Array.Resize
        byte[] output = new byte[input.Length + 4];
        Buffer.BlockCopy(input, 0, output, 0, input.Length);
        return output;
    }

    static byte[] Repeat(byte[] input)
    {
        byte[] output = new byte[input.Length * 2];
        Buffer.BlockCopy(input, 0, output, 0, input.Length);
        Buffer.BlockCopy(input, 0, output, input.Length, input.Length);
        return output;
    }

    static void Main()
    {
        byte[] input = { 1, 2, 3 };
        byte[] padded = Pad(input);
        byte[] repeated = Repeat(input);

        Console.WriteLine("Padded: [" + string.Join(", ", padded) + "]");
        Console.WriteLine("Repeated: [" + string.Join(", ", repeated) + "]");
    }
}