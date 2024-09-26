csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        System.Security.Cryptography.CspParameters csp = new CspParameters();
        csp.KeyContainerName = "MyKeyName";
        csp.Flags = CspProviderFlags.UseMachineKeyStore;
    }
}