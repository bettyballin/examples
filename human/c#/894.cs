csharp
using System;
using System.Security.Cryptography;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        string publicKeyX509PEM = "-----BEGIN CERTIFICATE-----...-----END CERTIFICATE-----";
        byte[] publicKeyX509DER = ConvertX509PemToDer(publicKeyX509PEM);
        RSA rsa = RSA.Create();
        rsa.ImportSubjectPublicKeyInfo(publicKeyX509DER, out _);
        RSAParameters parameters = rsa.ExportParameters(false);

        Console.WriteLine(BitConverter.ToString(parameters.Exponent));
        Console.WriteLine(BitConverter.ToString(parameters.Modulus));
    }

    static byte[] ConvertX509PemToDer(string pem)
    {
        string base64 = Regex.Replace(pem, @"-----BEGIN CERTIFICATE-----|-----END CERTIFICATE-----|\s", string.Empty);
        return Convert.FromBase64String(base64);
    }
}