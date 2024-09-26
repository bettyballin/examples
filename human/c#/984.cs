csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class P256
{
    public class Signing
    {
        public class PublicKey
        {
            private readonly byte[] _key;

            public PublicKey(byte[] x963Representation)
            {
                _key = x963Representation;
            }

            public bool IsValidSignature(ECDSASignature signature, byte[] data)
            {
                using var ecdsa = ECDsa.Create(ECCurve.CreateFromFriendlyName(ECCurveNames.NistP256));
                ecdsa.ImportSubjectPublicKeyInfo(_key, out _);
                return ecdsa.VerifyData(data, signature._signature);
            }
        }

        public class ECDSASignature
        {
            public readonly byte[] _signature;

            public ECDSASignature(byte[] rawRepresentation)
            {
                _signature = rawRepresentation;
            }
        }
    }
}

class Program
{
    static void Main()
    {
        var bytesArray = Convert.FromBase64String("your_public_key_here");
        var signature = Convert.FromBase64String("your_signature_here");
        var fileData = Encoding.UTF8.GetBytes("your_file_data_here");

        var publicKeyP265 = new P256.Signing.PublicKey(bytesArray);
        var ecdsaSignature = new P256.Signing.ECDSASignature(signature);
        var fileDataDigest = SHA512.Create().ComputeHash(fileData);

        var result = publicKeyP265.IsValidSignature(ecdsaSignature, fileDataDigest);

        Console.WriteLine(result);
    }
}