csharp
using System;
using System.IO;

class Program
{
    static void Main()
    {
        string fileName = "test.txt"; // replace with your file name
        string potentialPath = Path.Combine(@"c:\myroot\", fileName);
        if (Path.GetFullPath(potentialPath) != potentialPath)
        {
            Console.WriteLine("Potential path traversal detected.");
        }
        else
        {
            Console.WriteLine("Path seems safe.");
        }
    }
}