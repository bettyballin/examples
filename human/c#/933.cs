csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Web;

class Program
{
    static void Main()
    {
        string urlExample = "http://localhost/test/resource";
        string integratorKeyString = "dDASDaGdj5R1kf5151ladAFvv";
        byte[] keyToBytes = Encoding.UTF8.GetBytes(integratorKeyString.ToLower());
        Uri parsedUrl = new Uri(urlExample);
        byte[] signatureBytes = Encoding.UTF8.GetBytes(parsedUrl.AbsolutePath + ((DateTimeOffset)DateTime.UtcNow).ToUnixTimeMilliseconds());

        using (HMACSHA256 hmacSha256 = new HMACSHA256(keyToBytes))
        {
            byte[] signatureHash = hmacSha256.ComputeHash(signatureBytes);
            string signature = Convert.ToBase64String(signatureHash);
            Console.WriteLine(signature);
        }
    }
}