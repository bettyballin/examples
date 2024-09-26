csharp
using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        byte[] plain = System.Text.Encoding.ASCII.GetBytes("yourplain text");
        byte[] cipher = System.Text.Encoding.ASCII.GetBytes("yourcipher text");

        foreach (var kp in 
          Enumerable.Range(0, plain.Length).Aggregate(
            ( from x in Enumerable.Range(0, 256) 
              from y in Enumerable.Range(0, 256) 
              select new { x, y }).ToList(), 
            (pairs, i) => pairs.Intersect(
              from x in Enumerable.Range(0, 256) 
              select new { x, y = 
                ((cipher[i] - (plain[i] ^ x)) % 256) ^ x }).ToList()))
            Console.WriteLine(kp);
    }
}