csharp
using System;
using System.Linq;

class Program
{
    static void Main()
    {
        Console.WriteLine(ZigZag("PAYPALISHIRING", 3));
    }

    static string ZigZag(string input, int level)
    {
        var indexMap = GenerateIncreasingDecreasing(level);
        var result =
                input.Select((c, i) => new { 
                        Char = c, 
                        Index = indexMap[i % ((level>2)?(level + 1):level)] 
                    })
                    .GroupBy(x => x.Index)
                    .OrderBy(g => g.Key)
                    .SelectMany(x => x.Select(y => y.Char))
                    .ToArray();

        return new string(result);
    }

    static int[] GenerateIncreasingDecreasing(int level)
    {
        int[] result = new int[level > 2 ? level + 1 : level];
        for (int i = 0; i < level; i++)
        {
            result[i] = i;
        }
        if (level > 2)
        {
            for (int i = level - 2; i >= 1; i--)
            {
                result[level + level - 2 - i] = i;
            }
        }
        return result;
    }
}