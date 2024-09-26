csharp
using System;
using System.Security.Cryptography.X509Certificates;
using System.IO;

class Program
{
    static void Main()
    {
        var cert = new X509Certificate2();
        using (var stream = new MemoryStream(Properties.Resources.wildcard))
        {
            cert.Import(stream.ToArray(), "xxx", X509KeyStorageFlags.MachineKeySet | X509KeyStorageFlags.Exportable);
        }
    }
}