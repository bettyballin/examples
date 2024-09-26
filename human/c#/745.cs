csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var secretKey = "your_secret_key_here";
        var nonce = Guid.NewGuid().ToString();

        var sessionKey = HmacSha256(secretKey, "Encryption" + nonce);
        var sessionToken = HmacSha256(secretKey, "Token" + nonce);

        Console.WriteLine("SessionKey: " + sessionKey);
        Console.WriteLine("SessionToken: " + sessionToken);
    }

    static string HmacSha256(string key, string data)
    {
        using (var hmac = new HMACSHA256(Encoding.UTF8.GetBytes(key)))
        {
            var hash = hmac.ComputeHash(Encoding.UTF8.GetBytes(data));
            return BitConverter.ToString(hash).Replace("-", "").ToLower();
        }
    }
}