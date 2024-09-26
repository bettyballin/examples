csharp
using System;
using System.Security.Cryptography;

public class RSAPublicKey
{
    public byte[] Modulus { get; set; }
    public byte[] PublicExponent { get; set; }
}

public class Program
{
    public static void Main()
    {
        using (var rsa = RSA.Create())
        {
            rsa.ImportSubjectPublicKeyInfo(new byte[] { /* your public key bytes */ }, out _);
            var parameters = rsa.ExportParameters(false);
            var publicKey = new RSAPublicKey
            {
                Modulus = parameters.Modulus,
                PublicExponent = parameters.Exponent
            };
            Console.WriteLine(BitConverter.ToString(publicKey.Modulus));
            Console.WriteLine(BitConverter.ToString(publicKey.PublicExponent));
        }
    }
}