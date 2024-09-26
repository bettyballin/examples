csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string pemInputFile = "path_to_pem_input_file";
        string derOutputFile = "path_to_der_output_file";

        string command = $"openssl rsa -pubin -inform PEM -outform DER -in {pemInputFile} -out {derOutputFile}";

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