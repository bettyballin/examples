csharp
using System;
using System.IO;

class Program
{
    static void Main()
    {
        using (FileStream fs = 
               File.Open("MyFile.txt", FileMode.Open, FileAccess.Read, FileShare.None))
        {
            // use fs
            Console.WriteLine("File opened successfully.");
        }
    }
}