csharp
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string pemContents = new StreamReader("pkcs8privatekey.pem").ReadToEnd();
        var der = Convert.FromBase64String(pemContents.Replace("-----BEGIN PRIVATE KEY-----", "").Replace("-----END PRIVATE KEY-----", ""));
        RSACryptoServiceProvider rsa = DecodePrivateKeyInfo(der);

        byte[] data = Encoding.UTF8.GetBytes("Data to be signed");
        byte[] signature = rsa.SignData(data, new MD5CryptoServiceProvider());

        Console.WriteLine(BitConverter.ToString(signature));
    }

    static RSACryptoServiceProvider DecodePrivateKeyInfo(byte[] der)
    {
        byte[] privateKey = der;
        int keySize = 2048;
        byte[] modulus = new byte[keySize / 8];
        byte[] exponent = new byte[3];
        Array.Copy(privateKey, privateKey.Length - exponent.Length, exponent, 0, exponent.Length);
        Array.Copy(privateKey, privateKey.Length - modulus.Length - exponent.Length, modulus, 0, modulus.Length);

        RSACryptoServiceProvider rsa = new RSACryptoServiceProvider();
        RSAParameters parameters = new RSAParameters();
        parameters.Modulus = modulus;
        parameters.Exponent = exponent;
        rsa.ImportParameters(parameters);

        return rsa;
    }
}