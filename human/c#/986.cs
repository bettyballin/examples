csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string key = "your_secret_key_here";
        var hmac = new HMACSHA512(Encoding.UTF8.GetBytes(key));
        Console.WriteLine("HMACSHA512 instance created successfully.");
    }
}