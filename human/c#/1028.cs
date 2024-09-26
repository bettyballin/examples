csharp
using System;
using System.Security.Cryptography;

public class RSAPrivateKey
{
    public int Version { get; set; }
    public byte[] Modulus { get; set; }
    public byte[] PublicExponent { get; set; }
    public byte[] PrivateExponent { get; set; }
    public byte[] Prime1 { get; set; }
    public byte[] Prime2 { get; set; }
    public byte[] Exponent1 { get; set; }
    public byte[] Exponent2 { get; set; }
    public byte[] Coefficient { get; set; }
    public OtherPrimeInfos OtherPrimeInfos { get; set; }

    public class OtherPrimeInfos
    {
        public byte[] Prime { get; set; }
        public byte[] Exponent { get; set; }
        public byte[] Coefficient { get; set; }
    }

    public static RSAPrivateKey GenerateKey(int keySize)
    {
        using (var rsa = RSA.Create(keySize))
        {
            var privateKey = rsa.ExportParameters(true);
            var key = new RSAPrivateKey
            {
                Version = 0,
                Modulus = privateKey.Modulus,
                PublicExponent = privateKey.Exponent,
                PrivateExponent = privateKey.D,
                Prime1 = privateKey.P,
                Prime2 = privateKey.Q,
                Exponent1 = privateKey.DP,
                Exponent2 = privateKey.DQ,
                Coefficient = privateKey.InverseQ
            };
            return key;
        }
    }

    public static void Main()
    {
        var key = GenerateKey(2048);
        Console.WriteLine("Version: " + key.Version);
        Console.WriteLine("Modulus: " + BitConverter.ToString(key.Modulus));
        Console.WriteLine("Public Exponent: " + BitConverter.ToString(key.PublicExponent));
        Console.WriteLine("Private Exponent: " + BitConverter.ToString(key.PrivateExponent));
        Console.WriteLine("Prime 1: " + BitConverter.ToString(key.Prime1));
        Console.WriteLine("Prime 2: " + BitConverter.ToString(key.Prime2));
        Console.WriteLine("Exponent 1: " + BitConverter.ToString(key.Exponent1));
        Console.WriteLine("Exponent 2: " + BitConverter.ToString(key.Exponent2));
        Console.WriteLine("Coefficient: " + BitConverter.ToString(key.Coefficient));
    }
}