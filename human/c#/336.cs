csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string[] plainTexts = new string[]
        {
            "3736353433323120",
            "4e6f772069732074",
            "68652074696d6520",
            "666f722000000000"
        };

        string[] desInputs = new string[]
        {
            "3736353433323120",
            "6f946e16fad24c5c",
            "04231f78de7b1f4f",
            "f3019ab1e889d91e"
        };

        string[] desOutputs = new string[]
        {
            "21fb193693a16c28",
            "6c463f0cb7167a6f",
            "956ee891e889d91e",
            "f1d30f6849312ca4"
        };

        for (int i = 0; i < plainTexts.Length; i++)
        {
            Console.WriteLine($"=============Round {i + 1}==============");
            Console.WriteLine($"Plain text : {plainTexts[i]}");
            Console.WriteLine($"DES INPUT  : {desInputs[i]}");
            Console.WriteLine($"DES OUTPUT : {desOutputs[i]}");
        }

        Console.WriteLine($"===========Final Round============");
        Console.WriteLine($"Result: {desOutputs[desOutputs.Length - 1]}");
    }
}