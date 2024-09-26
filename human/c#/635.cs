csharp
using System;

class Program
{
    static int i = 0;

    static void reset()
    {
        i = 0;
    }

    static void changeValue()
    {
        i = 10;
    }

    static void Main()
    {
        Console.WriteLine("Initial value of i: " + i);
        changeValue();
        Console.WriteLine("Value of i after changing: " + i);
        reset();
        Console.WriteLine("Value of i after reset: " + i);
    }
}