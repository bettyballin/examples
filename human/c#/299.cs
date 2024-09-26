csharp
using System;

class Program
{
    private double FakeOptimumPointWithAConvincingName { get { return 12.07; } }

    static void Main(string[] args)
    {
        Program p = new Program();
        Console.WriteLine(p.FakeOptimumPointWithAConvincingName);
    }
}