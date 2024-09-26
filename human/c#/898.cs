csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class OaepExample
{
    public static void OeapDecrypt()
    {
        string privateKeyPath = "/Users/horton/tmp/key-examples/myserver.p8";
        string cipher64 = "k8AYnTV6RgzQXmD7qn8QwucDXGjbYct+qMVvDmMELTnUcCOeTp82oJ0BryZyEEGXVSZ2BFg95e72Jt9ZAKWNcot2rZ0+POcda8pzY/MfdwIpnSJKITovk8xHL3B/jZDJyQrLMmNPjVV/uBFY2vgKhhLhJzzAJATcGpNdw+gF+XI=";

        string privateKeyString = File.ReadAllText(privateKeyPath);
        privateKeyString = privateKeyString.Replace("-----BEGIN PRIVATE KEY-----", "").Replace("-----END PRIVATE KEY-----", "").Trim();

        byte[] privateKeyBytes = Convert.FromBase64String(privateKeyString);
        using (var rsa = RSA.Create())
        {
            rsa.ImportPkcs8PrivateKey(privateKeyBytes, out _);

            var oaepParams = new OaepParams
            {
                HashAlgorithm = HashAlgorithmName.SHA256,
                MaskGenerationFunction = MaskGenerationFunction.MGF1,
                MaskHashAlgorithm = HashAlgorithmName.SHA256,
                PSource = PSource.PSpecified.DEFAULT
            };

            byte[] cipherBytes = Convert.FromBase64String(cipher64);
            byte[] plainBytes = rsa.Decrypt(cipherBytes, oaepParams);

            string plainText = Encoding.UTF8.GetString(plainBytes);
            Console.WriteLine(plainText);
        }
    }
}

public class OaepParams
{
    public HashAlgorithmName HashAlgorithm { get; set; }
    public MaskGenerationFunction MaskGenerationFunction { get; set; }
    public HashAlgorithmName MaskHashAlgorithm { get; set; }
    public PSource PSource { get; set; }
}

public enum MaskGenerationFunction
{
    MGF1
}

public class PSource
{
    public static readonly PSource PSpecified = new PSource { Type = PSourceType.PSpecified };
    public PSourceType Type { get; set; }
}

public enum PSourceType
{
    PSpecified
}

class Program
{
    static void Main(string[] args)
    {
        OaepExample.OeapDecrypt();
    }
}