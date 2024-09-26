csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string CalculateSignature(string method, string nonce, string postdata, string secret)
    {
        // Encoding
        byte[] methodBytes = Encoding.ASCII.GetBytes("/" + method);
        byte[] noncePostdataBytes = Encoding.ASCII.GetBytes(nonce + postdata);
        byte[] secretBytes = Convert.FromBase64String(secret);

        // $hash = '/' . $method . hash('sha256', $nonce . $postdata, true);
        byte[] nonceHash = SHA256.Create().ComputeHash(noncePostdataBytes);
        byte[] hash = Concat(methodBytes, nonceHash);

        // $signature = hash_hmac('sha512', $hash, base64_decode($secret), true);
        byte[] signature = new HMACSHA512(secretBytes).ComputeHash(hash);

        // $signature = base64_encode($signature);
        string signatureB64 = Convert.ToBase64String(signature);

        return signatureB64; 
    }

    public static byte[] Concat(byte[] a, byte[] b)
    {
        byte[] result = new byte[a.Length + b.Length];
        Buffer.BlockCopy(a, 0, result, 0, a.Length);
        Buffer.BlockCopy(b, 0, result, a.Length, b.Length);
        return result;
    }

    public static void Main()
    {
        string method = "method";
        string nonce = "nonce";
        string postdata = "postdata";
        string secret = "secret";

        string signature = CalculateSignature(method, nonce, postdata, secret);
        Console.WriteLine(signature);
    }
}