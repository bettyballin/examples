csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        var process = new Process
        {
            StartInfo = new ProcessStartInfo
            {
                FileName = "openssl",
                Arguments = "x509 -req -days 1095 -in csr.csr -signkey private_key.pem -out certificate.crt",
                RedirectStandardOutput = true,
                UseShellExecute = false,
                CreateNoWindow = true
            }
        };

        process.Start();
        process.WaitForExit();
    }
}