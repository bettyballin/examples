csharp
using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int level = 5;
        int[] result = GenerateIncreasingDecreasing(level);
        Console.WriteLine(string.Join(", ", result));
    }

    public static int[] GenerateIncreasingDecreasing(int level)
    {
        var tempRange = Enumerable.Range(0, level).ToArray();
        var indexMap = (tempRange.Length < 2) ?
                        tempRange :
                        tempRange.Concat(Enumerable.Range(1, level-2).Reverse());
        return indexMap.ToArray();
    }
}