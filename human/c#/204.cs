csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        var process = new Process
        {
            StartInfo = new ProcessStartInfo
            {
                FileName = "cmd.exe",
                Arguments = "/c secedit /export /cfg myfile.inf /areas USER_RIGHTS",
                RedirectStandardOutput = true,
                UseShellExecute = false,
                CreateNoWindow = true
            }
        };

        process.Start();
        process.WaitForExit();
    }
}