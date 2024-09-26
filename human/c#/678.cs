csharp
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string hostname = System.Net.Dns.GetHostName();
        string command = $"setspn -D HOST/{hostname} {hostname}";
        Process.Start(new ProcessStartInfo("cmd.exe", $"/c {command}") { CreateNoWindow = true }).WaitForExit();
    }
}