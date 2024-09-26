csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string S4()
    {
        var rng = new RNGCryptoServiceProvider();
        var bytes = new byte[4];
        rng.GetBytes(bytes);
        return BitConverter.ToString(bytes).Replace("-", "").ToLower().Substring(1);
    }

    public static string GetNonce()
    {
        return (S4() + S4() + S4() + S4() + S4() + S4() + S4() + S4()).ToLower();
    }

    public static string GetTimeStamp()
    {
        return ((int)DateTime.UtcNow.Subtract(new DateTime(1970, 1, 1)).TotalSeconds).ToString();
    }

    public static string GetAuthHeader(string httpMethod, string requestUrl, string requestBody)
    {
        var CLIENT_KEY = "YOUR_API_USER";
        var SECRET_KEY = "YOUR_API_KEY";
        var AUTH_TYPE = "HMAC";

        var requestTimeStamp = GetTimeStamp();
        var nonce = GetNonce();
        requestUrl = requestUrl.ToLower();

        var signatureRawData = string.Join("", CLIENT_KEY, requestUrl, requestTimeStamp, nonce);
        var key = Convert.FromBase64String(SECRET_KEY);

        using (var hmac = new HMACSHA256(key))
        {
            var hash = hmac.ComputeHash(Encoding.UTF8.GetBytes(signatureRawData));
            var hashInBase64 = Convert.ToBase64String(hash);

            var header = string.Join(":", CLIENT_KEY, hashInBase64, nonce, requestTimeStamp);
            Console.WriteLine("header: " + header);

            return AUTH_TYPE + " " + header;
        }
    }

    public static void Main()
    {
        var httpMethod = "GET";
        var requestUrl = "https://example.com/api/endpoint";
        var requestBody = "";

        var authHeader = GetAuthHeader(httpMethod, requestUrl, requestBody);
        Console.WriteLine("Authorization Header: " + authHeader);
    }
}