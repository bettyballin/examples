csharp
using System;

class Program
{
    static void Main()
    {
        double value = 5000;
        double locationsInBase256 = Math.Ceiling(Math.Log(value, 2) / 8);
        Console.WriteLine(locationsInBase256);
    }
}