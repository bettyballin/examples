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
            process.StartInfo.Arguments = "genrsa -out private.pem 1024";
            process.Start();
            process.WaitForExit();
        }

        using (var process = new Process())
        {
            process.StartInfo.FileName = "openssl";
            process.StartInfo.Arguments = "rsa -in private.pem -out public.pem -outform PEM -pubout";
            process.Start();
            process.WaitForExit();
        }
    }
}