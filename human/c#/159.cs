csharp
using System;

class Program
{
    public static bool CompareArraysExhaustively(byte[] first, byte[] second)
    {
        if (first.Length != second.Length)
        {
            return false;
        }
        bool ret = true;
        for (int i = 0; i < first.Length; i++)
        {
            ret = ret & (first[i] == second[i]);
        }
        return ret;
    }

    static void Main(string[] args)
    {
        byte[] array1 = { 1, 2, 3, 4, 5 };
        byte[] array2 = { 1, 2, 3, 4, 5 };
        byte[] array3 = { 1, 2, 3, 4, 6 };

        Console.WriteLine(CompareArraysExhaustively(array1, array2));  // True
        Console.WriteLine(CompareArraysExhaustively(array1, array3));  // False
    }
}