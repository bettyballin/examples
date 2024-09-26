csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Signers;
using Org.BouncyCastle.OpenSsl;
using Org.BouncyCastle.Security;

public class Program
{
    public static string GenerateSignature(string message, string privateKeyPath)
    {
        byte[] messageBytes = Encoding.UTF8.GetBytes(message);
        ISigner signer = SignerUtilities.GetSigner("SHA-256withPLAIN-ECDSA");
        AsymmetricCipherKeyPair keyPair = GetPrivateKeyFromPemFile(privateKeyPath); // get secp128r1 key pair
        signer.Init(true, keyPair.Private);
        signer.BlockUpdate(messageBytes, 0, messageBytes.Length);
        byte[] signature = signer.GenerateSignature();
        return ByteArrayToString(signature); // https://stackoverflow.com/a/311179/9014097
    }

    private static AsymmetricCipherKeyPair GetPrivateKeyFromPemFile(string privateKeyPath)
    {
        using (var reader = new StreamReader(privateKeyPath))
        {
            var pemReader = new PemReader(reader);
            return pemReader.ReadObject<AsymmetricCipherKeyPair>();
        }
    }

    private static string ByteArrayToString(byte[] ba)
    {
        StringBuilder hex = new StringBuilder(ba.Length * 2);
        foreach (byte b in ba)
        {
            hex.AppendFormat("{0:x2}", b);
        }
        return hex.ToString();
    }

    public static void Main()
    {
        string message = "Hello, World!";
        string privateKeyPath = "path_to_your_private_key.pem";
        string signature = GenerateSignature(message, privateKeyPath);
        Console.WriteLine(signature);
    }
}