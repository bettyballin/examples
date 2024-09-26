csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var hmac = new HMACSHA256(Encoding.UTF8.GetBytes("secret"));
        var hash = hmac.ComputeHash(Encoding.UTF8.GetBytes("2012-10-01T17:48:56"));
        var hmacBase64 = Convert.ToBase64String(hash);
        Console.WriteLine(hmacBase64);
    }
}