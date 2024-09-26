csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string hostname = "your_hostname";
        string domainUser = "your_domain\\your_service_user";

        string command = $"setspn -S HOST/{hostname} {domainUser}";

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