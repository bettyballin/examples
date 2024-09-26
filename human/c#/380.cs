csharp
using System;

class Program
{
    private static string GetPath(string basePath, string fileName)
    {
        var fullPath = System.IO.Path.GetFullPath(System.IO.Path.Combine(basePath, fileName));
        if (fullPath.StartsWith(basePath))
            return fullPath;
        return null;
    }

    static void Main()
    {
        string basePath = @"C:\Temp";
        string fileName = "test.txt";
        Console.WriteLine(GetPath(basePath, fileName));
    }
}