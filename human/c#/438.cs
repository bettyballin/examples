csharp
using System;

class Program
{
    static void Main()
    {
        char[] charAArray = "Hello".ToCharArray();
        char[] charBArray = "World".ToCharArray();
        char[] result = new char[charAArray.Length];

        for (int i = 0; i < charAArray.Length; i++)
        {
            result[i] = (char)(charAArray[i] ^ charBArray[i]);
        }

        Console.WriteLine(new string(result));
    }
}