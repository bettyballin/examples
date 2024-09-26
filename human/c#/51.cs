csharp
using System;
using System.IO;
using System.Web;

class Program
{
    static void Main()
    {
        string filename = "example.txt"; // Replace with your file name
        string path = Path.Combine(@"c:\example\mydir", filename);
        FileInfo file = new FileInfo(path);
        Console.WriteLine(file.FullName);
    }
}