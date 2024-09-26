csharp
using System;

class Program
{
    static void Main()
    {
        string inputString = "Hello, World!";
        char[] chars = new char[inputString.Length];
        for (int i = 0; i < inputString.Length; i++)
        {
            chars[i] = (char)(inputString[i] + 1);
        }
        string outputString = new string(chars);
        Console.WriteLine(outputString);
    }
}