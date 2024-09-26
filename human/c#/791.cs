csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string curve = "ECDH_P256"; // choose a curve
        ECDiffieHellman ephem = ECDiffieHellman.Create(curve);
    }
}