csharp
using System;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        using (var process = new Process())
        {
            process.StartInfo.FileName = "openssl";
            process.StartInfo.Arguments = "rsa -pubout -in private_key.pem -out public_key.pem";
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.RedirectStandardOutput = true;
            process.StartInfo.RedirectStandardError = true;
            process.Start();

            Console.WriteLine(process.StandardOutput.ReadToEnd());
            Console.WriteLine(process.StandardError.ReadToEnd());

            process.WaitForExit();
        }
    }
}