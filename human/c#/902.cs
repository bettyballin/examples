csharp
using System;

class Program
{
    private static string secretUser = "SecretUser";

    static void Main(string[] args)
    {
        Console.WriteLine($" > Hello {secretUser}");

        LoadPlugins();

        Console.WriteLine($" > System fully loaded! Hello again {secretUser}");
    }

    static void LoadPlugins()
    {
        Console.WriteLine(" > Loading plugins...");
        // Add plugin loading logic here
        Console.WriteLine(" > Plugins loaded.");
    }
}