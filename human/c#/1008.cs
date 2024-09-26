csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        using ECDsa ecdsa = ECDsa.Create(ECCurve.NamedCurves.nistP256);

        byte[] privatePkcs8Der = ecdsa.ExportPkcs8PrivateKey();
        byte[] privateSec1Der = ecdsa.ExportECPrivateKey();
        byte[] publicX509Der = ecdsa.ExportSubjectPublicKeyInfo();

        Console.WriteLine("Private Key (PKCS#8 DER):");
        Console.WriteLine(Convert.ToBase64String(privatePkcs8Der));

        Console.WriteLine("Private Key (SEC1 DER):");
        Console.WriteLine(Convert.ToBase64String(privateSec1Der));

        Console.WriteLine("Public Key (X509 DER):");
        Console.WriteLine(Convert.ToBase64String(publicX509Der));
    }
}