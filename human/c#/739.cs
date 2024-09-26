csharp
using System;

class Program
{
    static void Main()
    {
        foreach (int[] poly in GenPolys(4))
        {
            Console.WriteLine(string.Join(", ", poly));
        }
    }

    static System.Collections.Generic.IEnumerable<int[]> GenPolys(int n)
    {
        for (int i = 0; i < Math.Pow(2, n); i++)
        {
            int[] poly = new int[n];
            for (int j = 0; j < n; j++)
            {
                poly[j] = (i >> j) & 1;
            }
            yield return poly;
        }
    }
}