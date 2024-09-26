csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string key = "your_base64_key_here";
        var hmac = new HMACSHA512(Convert.FromBase64String(key));
        Console.WriteLine(hmac.ToString());
    }
}