csharp
using System;
using System.IO;
using System.Text;
using System.Security.Cryptography;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Signers;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;

class Program
{
    public static void Main()
    {
        var asymmetricCipherKeyPair = ReadAsymmetricCipherKeyPairFromPem("./key.pem");
        var signature = GetSignature(asymmetricCipherKeyPair.Private, "Some message");
        Console.WriteLine(signature);
    }

    private static string GetSignature(AsymmetricKeyParameter privateKeyParameter, string message)
    {
        var signer = SignerUtilities.GetSigner("SHA-256withECDSA");

        signer.Init(true, privateKeyParameter);

        signer.BlockUpdate(Encoding.ASCII.GetBytes(message), 0, Encoding.ASCII.GetBytes(message).Length);

        var signature = signer.GenerateSignature();

        return Convert.ToBase64String(signature);
    }

    private static AsymmetricCipherKeyPair ReadAsymmetricCipherKeyPairFromPem(string pathToPem)
    {
        using var reader = File.OpenText(pathToPem); 
        var keyPair = (AsymmetricCipherKeyPair)new PemReader(reader).ReadObject();

        return keyPair;
    }
}