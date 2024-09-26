csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string command = "openssl pkcs8 -topk8 -nocrypt -in eckey.pem -out ec2.pem";
        ProcessStartInfo startInfo = new ProcessStartInfo
        {
            FileName = "/bin/bash",
            Arguments = $"-c \"{command}\"",
            RedirectStandardOutput = true,
            UseShellExecute = false,
            CreateNoWindow = true,
        };

        Process process = Process.Start(startInfo);
        process.WaitForExit();
    }
}