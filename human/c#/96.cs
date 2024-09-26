csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string command = "stsadm.exe";
        string arguments = "-o deploysolution -name MyApp.wsp -immediate -allowgacdeployment -force";
        Process process = new Process();
        process.StartInfo.FileName = command;
        process.StartInfo.Arguments = arguments;
        process.StartInfo.UseShellExecute = false;
        process.StartInfo.RedirectStandardOutput = true;
        process.Start();
        Console.WriteLine(process.StandardOutput.ReadToEnd());
        process.WaitForExit();
    }
}