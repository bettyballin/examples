csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string projectPath = @"C:\Path\To\Project";

        string command1 = $"sourceanalyzer -b project -vsversion 10.0 {projectPath}\\Additional.Assembly.1.dll {projectPath}\\Additional.Assembly.2.dll {projectPath}\\Additional.Assembly.3.dll";
        string command2 = $"sourceanalyzer -b project -scan -f MyResults.fpr";

        ExecuteCommand(command1);
        ExecuteCommand(command2);
    }

    static void ExecuteCommand(string command)
    {
        Process process = new Process();
        process.StartInfo.FileName = "cmd.exe";
        process.StartInfo.Arguments = $"/c {command}";
        process.StartInfo.UseShellExecute = false;
        process.StartInfo.RedirectStandardOutput = true;
        process.Start();
        Console.WriteLine(process.StandardOutput.ReadToEnd());
        process.WaitForExit();
    }
}