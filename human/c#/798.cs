csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var key = new byte[32];
        using (var rng = RandomNumberGenerator.Create())
        {
            rng.GetBytes(key);
        }

        var data = "foo";
        using (var hmac = new HMACSHA256(key))
        {
            var mac = hmac.ComputeHash(Encoding.UTF8.GetBytes(data));
            var macHex = BitConverter.ToString(mac).Replace("-", "").ToLower();
            Console.WriteLine(data + macHex);
        }
    }
}