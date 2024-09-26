csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class RSADigestSigner
{
    private readonly StaticDigest _digest;

    public RSADigestSigner(StaticDigest digest)
    {
        _digest = digest;
    }

    public string GenerateSignature()
    {
        using var rsa = RSA.Create();
        var dataToSign = _digest.GetDigest();
        var signatureBytes = rsa.SignData(dataToSign, HashAlgorithmName.SHA1, RSASignaturePadding.Pkcs1);
        return Convert.ToBase64String(signatureBytes);
    }
}

public class StaticDigest
{
    private readonly byte[] _digest;

    public StaticDigest(string data, string algorithm)
    {
        using var hash = HashAlgorithm.Create(algorithm);
        _digest = hash.ComputeHash(Encoding.UTF8.GetBytes(data));
    }

    public byte[] GetDigest()
    {
        return _digest;
    }
}

class Program
{
    static void Main()
    {
        var paramDataToSign = "Hello, World!";
        var signature = new RSADigestSigner(new StaticDigest(paramDataToSign, "SHA1")).GenerateSignature();
        Console.WriteLine(signature);
    }
}