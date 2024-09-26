csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.IO;
using System.Security.Cryptography.X509Certificates;

public class RSAKeyPair
{
    public string alg { get; set; }
    public string n { get; set; }
    public string e { get; set; }
    public string d { get; set; }
}

public class Program
{
    public static bool TestSigning(RSAKeyPair keySet)
    {
        if (keySet.alg != "RS512")
        {
            throw new ArgumentException("Only SHA512 is supported.");
        }

        var n = GetBigInteger(FromBase64Url(keySet.n));
        var d = GetBigInteger(FromBase64Url(keySet.d));
        var e = GetBigInteger(FromBase64Url(keySet.e));

        var rsaParams = RecoverRSAParameters(n, e, d);

        RSACryptoServiceProvider rsaProvider = new RSACryptoServiceProvider(512);
        rsaProvider.ImportParameters(rsaParams);

        var hasher = SHA512.Create();

        var testmsg = Encoding.UTF8.GetBytes("TestMsg");
        var hash = hasher.ComputeHash(new MemoryStream(testmsg));

        var oid = CryptoConfig.MapNameToOID("SHA512");

        var signedData = rsaProvider.SignHash(hash, oid);
        var isSigned = rsaProvider.VerifyHash(hash, oid, signedData);

        return isSigned;
    }

    private static byte[] FromBase64Url(string base64Url)
    {
        string padded = base64Url.Length % 4 == 0
            ? base64Url : base64Url + "====".Substring(base64Url.Length % 4);
        string base64 = padded.Replace("_", "/").Replace("-", "+");
        return Convert.FromBase64String(base64);
    }

    private static System.Numerics.BigInteger GetBigInteger(byte[] data)
    {
        return new System.Numerics.BigInteger(data);
    }

    private static RSAParameters RecoverRSAParameters(System.Numerics.BigInteger n, System.Numerics.BigInteger e, System.Numerics.BigInteger d)
    {
        var parameters = new RSAParameters();
        parameters.Modulus = n.ToByteArray();
        parameters.Exponent = e.ToByteArray();
        parameters.D = d.ToByteArray();
        return parameters;
    }

    public static void Main()
    {
        RSAKeyPair keySet = new RSAKeyPair
        {
            alg = "RS512",
            n = "your_base64_url_encoded_modulus",
            e = "your_base64_url_encoded_public_exponent",
            d = "your_base64_url_encoded_private_exponent"
        };
        Console.WriteLine(TestSigning(keySet));
    }
}