csharp
using System;

class Program
{
    static void Main()
    {
        char[] charAArray = { '1', '2', '3' };
        char[] charBArray = { '2', '3', '4' };
        char[] result = new char[charAArray.Length];

        for (int i = 0; i < charAArray.Length; i++)
        {
            result[i] = (char)((charAArray[i] ^ charBArray[i]) + '0');
        }

        Console.WriteLine(string.Join("", result));
    }
}