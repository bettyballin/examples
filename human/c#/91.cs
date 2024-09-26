csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string drive = "X:";
        string path = @"D:\really really really\long path\that you can shorten";

        var process = new Process
        {
            StartInfo = new ProcessStartInfo
            {
                FileName = "cmd.exe",
                Arguments = $"/c subst {drive} \"{path}\"",
                UseShellExecute = false,
                RedirectStandardOutput = true,
                RedirectStandardError = true,
                CreateNoWindow = true,
            }
        };

        process.Start();
        process.WaitForExit();
    }
}