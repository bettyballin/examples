csharp
using System;
using System.Security.Cryptography.X509Certificates;

class Program
{
    static void Main()
    {
        string cerFile = "path_to_your_certificate_file.cer";
        X509Certificate2 cer = new X509Certificate2(cerFile);
        Console.WriteLine(cer.Subject);
    }
}