csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string command = "netsh http add sslcert ipport=0.0.0.0:8000 certhash=000...a5e6 appid={001-...-FEFF}";
        Process process = new Process();
        process.StartInfo.FileName = "cmd.exe";
        process.StartInfo.Arguments = "/C " + command;
        process.StartInfo.UseShellExecute = false;
        process.StartInfo.RedirectStandardOutput = true;
        process.Start();
        Console.WriteLine(process.StandardOutput.ReadToEnd());
        process.WaitForExit();
    }
}