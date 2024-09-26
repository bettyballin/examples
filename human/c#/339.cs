csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Linq;

class Program
{
    static void Main()
    {
        var token = "5f1fa09364a6ae7e35a090b434f182652ab8dd76:{\"expiration\": 1353759442.0991001, \"channel\": \"dreamhacksc2\", \"user_agent\": \".*\"}";
        var encoding = new UTF8Encoding();
        var privateKey = "Wd75Yj9sS26Lmhve";
        using (HMACSHA1 hmac_sha1 = new HMACSHA1(encoding.GetBytes(privateKey)))
        {
            byte[] result = hmac_sha1.ComputeHash(encoding.GetBytes(token));
            string hexString = String.Join("", result.Select(a => a.ToString("x2")));
            Console.WriteLine(hexString);
        }
    }
}