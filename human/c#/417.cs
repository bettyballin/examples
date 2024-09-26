csharp
using System;

class Program
{
    static void Main()
    {
        string Entropy = "1, 3, 5, 7, 9, 11, 15, 17, 19";
        var parts = Entropy.Split(new[] { ',' }, StringSplitOptions.RemoveEmptyEntries);
        byte[] bytes = Array.ConvertAll(parts, p => byte.Parse(p.Trim()));
        
        foreach (var b in bytes)
        {
            Console.WriteLine(b);
        }
    }
}