csharp
using System;
using System.Collections.Generic;

public class Program
{
    public static string GetKeySize(string keyOption)
    {
        var keySizes = new Dictionary<string, string>
        {
            {"KO 1", "Three-key Triple DES"},
            {"KO 2", "Two-key Triple DES"}
        };
        return keySizes.ContainsKey(keyOption) ? keySizes[keyOption] : "Unknown key size";
    }

    public static void Main()
    {
        var keyOption = "KO 1";
        var keySize = GetKeySize(keyOption);
        Console.WriteLine(keySize);

        keyOption = "KO 2";
        keySize = GetKeySize(keyOption);
        Console.WriteLine(keySize);
    }
}