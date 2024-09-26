csharp
using System;

class Program
{
    static void Main()
    {
        int[] v = { 1, 2, 3, 4, 5 };
        int p = 2;
        int MX = 3;
        int y;

        v[p] -= MX; 
        y = v[p];

        Console.WriteLine(y);
    }
}