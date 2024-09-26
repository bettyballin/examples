csharp
using System;
using System.Linq;

public static class HexExtensions
{
    public static byte[] ParseAsBytes(this string input)
    {
        return Enumerable.Range(0, input.Length)
                         .Where(x => x % 2 == 0)
                         .Select(x => Convert.ToByte(input.Substring(x, 2), 16))
                         .ToArray();
    }

    public static string ToHexString(this byte[] bytes)
    {
        return string.Concat(bytes.Select(b => b.ToString("x2")));
    }
}

public class Program
{
    public static void Main()
    {
        var input = "0001020304050607";

        var bytes = input.ParseAsBytes();
        Console.WriteLine(string.Join(", ", bytes.Select(b => $"0x{b:x2}")));

        var result = bytes.ToHexString();
        Console.WriteLine(result);
    }
}