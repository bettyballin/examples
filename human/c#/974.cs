csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        string nonce = "nonce";
        string secret = "c2VjcmV0";

        string method = "auth/register";
        var param = new Dictionary<string, string>
        {
            {"email", "test@test.com"},
            {"password", "Password1234"},
            {"customerId", "1234"}
        };

        var postdata = string.Join("&", param.Select(x => x.Key + "=" + x.Value));
        Console.WriteLine("Postdata: " + postdata);

        var hash = "/" + method + GetSha256Hash(nonce + postdata);
        var signature = GetHmacSha512Hash(hash, Convert.FromBase64String(secret));
        signature = Convert.ToBase64String(signature);

        Console.WriteLine("Signature: " + signature);
    }

    static byte[] GetSha256Hash(string input)
    {
        using (var sha256 = SHA256.Create())
        {
            return sha256.ComputeHash(Encoding.UTF8.GetBytes(input));
        }
    }

    static byte[] GetHmacSha512Hash(string input, byte[] key)
    {
        using (var hmac = new HMACSHA512(key))
        {
            return hmac.ComputeHash(Encoding.UTF8.GetBytes(input));
        }
    }
}