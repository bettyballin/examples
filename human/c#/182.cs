csharp
using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static void Main(string[] args)
    {
        string path = @"C:\path\to\directory";
        List<string> files = new List<string>();

        try
        {
            Directory.GetFiles(path)
                .ToList()
                .ForEach(s => files.Add(s));

            Directory.GetDirectories(path)
                .ToList()
                .ForEach(s => AddFiles(s, files));
        }
        catch (UnauthorizedAccessException ex)
        {
            // ok, so we are not allowed to dig into that directory. Move on.
        }

        foreach (var file in files)
        {
            Console.WriteLine(file);
        }
    }

    static void AddFiles(string path, List<string> files)
    {
        try
        {
            Directory.GetFiles(path)
                .ToList()
                .ForEach(s => files.Add(s));

            Directory.GetDirectories(path)
                .ToList()
                .ForEach(s => AddFiles(s, files));
        }
        catch (UnauthorizedAccessException ex)
        {
            // ok, so we are not allowed to dig into that directory. Move on.
        }
    }
}