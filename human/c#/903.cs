csharp
using System;
using System.Reflection;
using System.Linq;

public class Hacker
{
    public static void Main()
    {
        var hacker = new Hacker();
        hacker.Run();
    }

    public void Run()
    {
        var mainClass = System.AppDomain.CurrentDomain.GetAssemblies()
            .Select(asm => asm.EntryPoint?.DeclaringType)
            .Single(x => x?.Name == "Program");

        var fieldDef = mainClass
            .GetField("secretUser",
                BindingFlags.DeclaredOnly | BindingFlags.NonPublic | BindingFlags.Static);

        fieldDef.SetValue(mainClass, "HackerPlugin");
    }
}

public class Program
{
    private static string secretUser = "OriginalValue";

    public static void Main()
    {
        Console.WriteLine(secretUser);
        var hacker = new Hacker();
        hacker.Run();
        Console.WriteLine(secretUser);
    }
}