csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string command = "aspnet_regiis -pe \"connectionStrings\" -app \"/MyApp\" -prov \"CustomProvider\"";
        ProcessStartInfo startInfo = new ProcessStartInfo
        {
            FileName = "cmd.exe",
            Arguments = "/c " + command,
            RedirectStandardOutput = true,
            UseShellExecute = false,
            CreateNoWindow = true
        };
        Process process = Process.Start(startInfo);
        Console.WriteLine(process.StandardOutput.ReadToEnd());
        process.WaitForExit();
    }
}