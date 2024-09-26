csharp
using System;
using System.Text;

public static class Extensions
{
    public static string ToHex(this byte[] bytes, bool upperCase)
    {
        StringBuilder result = new StringBuilder(bytes.Length*2);

        for (int i = 0; i < bytes.Length; i++)
            result.Append(bytes[i].ToString(upperCase ? "X2" : "x2"));

        return result.ToString();
    }
}

class Program
{
    static void Main()
    {
        byte[] bytes = { 1, 2, 3, 4, 5 };
        Console.WriteLine(bytes.ToHex(false));
        Console.WriteLine(bytes.ToHex(true));
    }
}