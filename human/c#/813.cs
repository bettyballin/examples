csharp
using System;
using System.Security.Cryptography;

public class SubjectPublicKeyInfo
{
    public AlgorithmIdentifier Algorithm { get; set; }
    public byte[] SubjectPublicKey { get; set; }
}

public class AlgorithmIdentifier
{
    public string ObjectId { get; set; }
    public byte[] Parameters { get; set; }
}

class Program
{
    static void Main()
    {
        var rsa = RSA.Create(2048);
        var parameters = rsa.ExportParameters(false);

        var subjectPublicKeyInfo = new SubjectPublicKeyInfo
        {
            Algorithm = new AlgorithmIdentifier
            {
                ObjectId = "1.2.840.113549.1.1.1", // rsa
                Parameters = null
            },
            SubjectPublicKey = parameters.Modulus
        };

        Console.WriteLine($"Algorithm ObjectId: {subjectPublicKeyInfo.Algorithm.ObjectId}");
        Console.WriteLine($"Subject Public Key: {BitConverter.ToString(subjectPublicKeyInfo.SubjectPublicKey).Replace("-", " ")}");
    }
}