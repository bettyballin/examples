csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string command1 = "\"C:\\Program Files (x86)\\Microsoft SDKs\\Windows\\v7.1A\\Bin\\signtool.exe\" sign /f key.pfx /p abc123 /t http://timestamp.comodoca.com /v \"MyCoolApplication.exe\"";
        string command2 = "\"C:\\Program Files (x86)\\Microsoft SDKs\\Windows\\v7.1A\\Bin\\signtool.exe\" sign /f key.pfx /p abc123 /fd sha256 /tr http://timestamp.comodoca.com/?td=sha256 /td sha256 /v \"MyCoolApplication.exe\"";

        ExecuteCommand(command1);
        ExecuteCommand(command2);
    }

    static void ExecuteCommand(string command)
    {
        ProcessStartInfo startInfo = new ProcessStartInfo
        {
            FileName = "cmd.exe",
            Arguments = "/C " + command,
            RedirectStandardOutput = true,
            UseShellExecute = false,
            CreateNoWindow = true
        };

        Process process = Process.Start(startInfo);
        process.WaitForExit();
    }
}