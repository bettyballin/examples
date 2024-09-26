csharp
using System;
using System.Linq;

class Program
{
    static void Main()
    {
        string[] parts = { "12", "34", "56", "78" };
        byte[] bytes = Array.ConvertAll(parts, p => byte.Parse(p, System.Globalization.NumberStyles.HexNumber));
        Console.WriteLine(string.Join(", ", bytes));
    }
}