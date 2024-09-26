csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        CngProvider keyStorageProvider = new CngProvider("Microsoft Software Key Storage Provider");
        CngKeyCreationParameters keyCreationParameters = new CngKeyCreationParameters()
        {
            ExportPolicy = CngExportPolicies.AllowPlaintextExport,
            Provider = keyStorageProvider
        };

        Console.WriteLine(keyCreationParameters.ExportPolicy);
        Console.WriteLine(keyCreationParameters.Provider.Name);
    }
}