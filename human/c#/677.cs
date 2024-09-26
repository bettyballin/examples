csharp
using System;
using System.Diagnostics;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        foreach (Process proc in Process.GetProcesses())
        {
            try
            {
                string exePath = proc.MainModule.FileName;
                string hash = CalculateHash(exePath);
                Console.WriteLine($"Process: {proc.ProcessName}, Hash: {hash}");
            }
            catch
            { }
        }
    }

    static string CalculateHash(string filePath)
    {
        using (var md5 = MD5.Create())
        {
            using (var stream = System.IO.File.OpenRead(filePath))
            {
                var hash = md5.ComputeHash(stream);
                return BitConverter.ToString(hash).Replace("-", "").ToLowerInvariant();
            }
        }
    }
}