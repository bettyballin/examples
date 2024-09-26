csharp
using System;
using System.Security.Cryptography;

public class RSACryptoServiceProvider : RSA
{
    public RSACryptoServiceProvider() 
        : this(1024) { }

    public RSACryptoServiceProvider(int dwKeySize)
    {
        KeySize = dwKeySize;
    }

    public override byte[] Encrypt(byte[] rgb, int padding)
    {
        if (PublicOnly && rgb == null)
        {
            GenerateKeyPair();
        }
        return base.Encrypt(rgb, padding);
    }

    public override byte[] Decrypt(byte[] rgb, int padding)
    {
        if (PublicOnly && rgb == null)
        {
            GenerateKeyPair();
        }
        return base.Decrypt(rgb, padding);
    }

    private void GenerateKeyPair()
    {
        using (var rsa = RSA.Create(KeySize))
        {
            ImportParameters(rsa.ExportParameters(true));
        }
    }
}