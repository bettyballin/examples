csharp
using System;

class Program
{
    static void Main()
    {
        double locationsInBase64 = Math.Ceiling(Math.Log(5000, 2) / 6);
        Console.WriteLine(locationsInBase64);
    }
}