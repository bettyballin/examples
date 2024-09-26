csharp
using System;
using System.Runtime.InteropServices;

class Program
{
    [DllImport("mscoree.dll", CharSet = CharSet.Unicode)]
    static extern bool StrongNameSignatureVerificationEx(string wszFilePath, bool fForceVerification, ref bool pfWasVerified);

    static void Main()
    {
        bool wasVerified = false;
        string filePath = @"C:\Path\To\Your\Assembly.dll";
        bool result = StrongNameSignatureVerificationEx(filePath, true, ref wasVerified);
        Console.WriteLine($"Verification result: {result}");
        Console.WriteLine($"Was verified: {wasVerified}");
    }
}