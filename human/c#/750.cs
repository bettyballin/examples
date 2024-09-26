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
            process.StartInfo.Arguments = "asn1parse -i -dump -inform DER < your.signed.cms";
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.RedirectStandardOutput = true;
            process.StartInfo.RedirectStandardError = true;
            process.Start();

            Console.WriteLine(process.StandardOutput.ReadToEnd());
            Console.WriteLine(process.StandardError.ReadToEnd());
        }
    }
}