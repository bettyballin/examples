csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        string command = "openssl pkcs12 -export -in certificate.crt -inkey private_key.pem -CSP \"Microsoft Enhanced RSA and AES Cryptographic Provider\" -out TEST_pfx.pfx";
        ProcessStartInfo startInfo = new ProcessStartInfo
        {
            FileName = "cmd.exe",
            Arguments = $"/c {command}",
            RedirectStandardOutput = true,
            RedirectStandardError = true,
            UseShellExecute = false,
            CreateNoWindow = true
        };

        Process process = new Process { StartInfo = startInfo };
        process.Start();
        string output = process.StandardOutput.ReadToEnd();
        string error = process.StandardError.ReadToEnd();
        process.WaitForExit();

        Console.WriteLine(output);
        Console.WriteLine(error);
    }
}