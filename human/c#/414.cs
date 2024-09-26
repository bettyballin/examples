csharp
using System;
using System.IO;

public class Program
{
    public static string CreateTempFile()
    {
        return Path.GetTempFileName();
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(CreateTempFile());
    }
}