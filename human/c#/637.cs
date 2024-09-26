csharp
using System;
using System.Configuration;

class Program
{
    static void Main()
    {
        string HashAlgorithmProviderConfiguration = "HashAlgorithmProviderConfiguration";
        string hashAlgoTypeString = ConfigurationManager.AppSettings[HashAlgorithmProviderConfiguration];
        Console.WriteLine(hashAlgoTypeString);
    }
}