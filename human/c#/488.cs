csharp
using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        byte[] byteKey = { 1, 2, 3, 4, 5 };
        string sKey = Convert.ToBase64String(byteKey);
        byte[] byteKey2 = Convert.FromBase64String(sKey);
        bool equal = byteKey.SequenceEqual(byteKey2);
        Console.WriteLine(equal); // will be true
    }
}