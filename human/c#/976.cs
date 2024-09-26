csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string method = "auth/register";
        string nonce = "nonce";
        string postdata = "email=test%40test.com&password=Password1234&customerId=1234";
        string secret = "c2VjcmV0";

        string signatureB64 = CalculateSignature(method, nonce, postdata, secret);

        Console.WriteLine(signatureB64);
    }

    static string CalculateSignature(string method, string nonce, string postdata, string secret)
    {
        string data = $"{method}{nonce}{postdata}";
        byte[] bytes = Encoding.UTF8.GetBytes(data);
        byte[] key = Convert.FromBase64String(secret);
        using (HMACSHA256 hmac = new HMACSHA256(key))
        {
            byte[] signature = hmac.ComputeHash(bytes);
            return Convert.ToBase64String(signature);
        }
    }
}