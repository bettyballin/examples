csharp
using System;

class Program
{
    static void Main()
    {
        string directory;

        if (Environment.Is64BitOperatingSystem)
        {
            directory = System.IO.Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Windows), "Sysnative");
        }
        else
        {
            directory = Environment.GetFolderPath(Environment.SpecialFolder.System);
        }

        Console.WriteLine(directory);
    }
}