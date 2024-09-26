csharp
using System;
using System.Linq;

public static class HexHelper
{
    public static byte[] ParseAsBytes(string s)
    {
        return Enumerable.Range(0, s.Length / 2)
                         .Select(i => byte.Parse(s.Substring(i * 2, 2), 
                                                 System.Globalization.NumberStyles.AllowHexSpecifier))
                         .ToArray();
    }

    public static string ToHexString(this byte[] buffer)
    {
        return string.Concat(buffer.Select(i => i.ToString("X2")));
    }
}

class Program
{
    static void Main()
    {
        string hexString = "48656c6c6f20576f726c64";
        byte[] bytes = HexHelper.ParseAsBytes(hexString);
        Console.WriteLine(bytes.ToHexString());
    }
}