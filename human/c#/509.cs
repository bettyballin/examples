csharp
using System;

class Program
{
    static void Main()
    {
        byte[] array = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        foreach (var item in array)
        {
            Console.Write(item + " ");
        }
    }
}