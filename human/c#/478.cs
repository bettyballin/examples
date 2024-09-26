csharp
using System;

class Program
{
    static void Main()
    {
        string passPhrase = "Mypassphare>&";
        string command = $"echo \"{passPhrase}\" | base64";

        Console.WriteLine($"Original Passphrase: {passPhrase}");
        Console.WriteLine($"Command: {command}");
    }
}