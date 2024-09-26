csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Collections.Generic;

public class RsaMwe
{
    public static bool Demo()
    {
        var strings = RsaKeyGen();

        var privKey = Convert.FromBase64String(strings[0]);
        var pubKey = Convert.FromBase64String(strings[1]);

        var clearText = "Hello World!";
        var clearText64 = Convert.ToBase64String(Encoding.Default.GetBytes(clearText));

        var encrypted64 = RsaEncrypt(pubKey, clearText64);
        var decrypted64 = RsaDecrypt(privKey, encrypted64);

        return clearText == Encoding.Default.GetString(Convert.FromBase64String(decrypted64));
    }

    public static List<string> RsaKeyGen()
    {
        List<string> keyPair = new List<string>();

        using RSA rsa = RSA.Create(2048);

        keyPair.Add(Convert.ToBase64String(rsa.ExportParameters(true).GetRsaPrivateKeyBytes()));
        keyPair.Add(Convert.ToBase64String(rsa.ExportParameters(false).GetRsaPublicKeyBytes()));

        return keyPair;
    }

    public static string RsaEncrypt(byte[] pubKey, string clearText64)
    {
        using RSA rsa = RSA.Create(2048);
        rsa.ImportParameters(GetRsaParameters(pubKey));

        return Convert.ToBase64String(rsa.Encrypt(Convert.FromBase64String(clearText64), RSAEncryptionPadding.Pkcs1));
    }

    public static string RsaDecrypt(byte[] privKey, string cypherText64)
    {
        using RSA rsa = RSA.Create(2048);
        rsa.ImportParameters(GetRsaParameters(privKey));

        return Convert.ToBase64String(rsa.Decrypt(Convert.FromBase64String(cypherText64), RSAEncryptionPadding.Pkcs1));
    }

    private static RSAParameters GetRsaParameters(byte[] keyBytes)
    {
        RSAParameters rsaParameters = new RSAParameters();
        rsaParameters.Modulus = keyBytes.Take(256).ToArray();
        rsaParameters.Exponent = keyBytes.Skip(256).Take(3).ToArray();
        rsaParameters.D = keyBytes.Skip(259).Take(256).ToArray();
        rsaParameters.P = keyBytes.Skip(515).Take(128).ToArray();
        rsaParameters.Q = keyBytes.Skip(643).Take(128).ToArray();
        rsaParameters.DP = keyBytes.Skip(771).Take(128).ToArray();
        rsaParameters.DQ = keyBytes.Skip(899).Take(128).ToArray();
        rsaParameters.InverseQ = keyBytes.Skip(1027).Take(128).ToArray();

        return rsaParameters;
    }

    private static byte[] GetRsaPrivateKeyBytes(this RSAParameters rsaParameters)
    {
        byte[] privateKeyBytes = new byte[1162];
        rsaParameters.Modulus.CopyTo(privateKeyBytes, 0);
        rsaParameters.Exponent.CopyTo(privateKeyBytes, 256);
        rsaParameters.D.CopyTo(privateKeyBytes, 259);
        rsaParameters.P.CopyTo(privateKeyBytes, 515);
        rsaParameters.Q.CopyTo(privateKeyBytes, 643);
        rsaParameters.DP.CopyTo(privateKeyBytes, 771);
        rsaParameters.DQ.CopyTo(privateKeyBytes, 899);
        rsaParameters.InverseQ.CopyTo(privateKeyBytes, 1027);

        return privateKeyBytes;
    }

    private static byte[] GetRsaPublicKeyBytes(this RSAParameters rsaParameters)
    {
        byte[] publicKeyBytes = new byte[258];
        rsaParameters.Modulus.CopyTo(publicKeyBytes, 0);
        rsaParameters.Exponent.CopyTo(publicKeyBytes, 256);

        return publicKeyBytes;
    }

    public static void Main()
    {
        Console.WriteLine(Demo());
    }
}