csharp
using System;
using System.Linq;

class Program
{
    static void Main()
    {
        var rBar = new[] { 1, 2, 3 };
        var em = new[] { 4, 5, 6 };
        var d = new[] { 7, 8, 9 };

        // Either
        var result1 = Tuple.Create(rBar, em, d);
        Console.WriteLine(string.Join(", ", result1.Item1) + " " + string.Join(", ", result1.Item2) + " " + string.Join(", ", result1.Item3));

        // Or
        var result2 = rBar.Concat(em).Concat(d).ToArray();
        Console.WriteLine(string.Join(", ", result2));
    }
}