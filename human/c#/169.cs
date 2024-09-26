csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string someString = "Hello, World!";
        string hashedString = BitConverter.ToString(new SHA512CryptoServiceProvider().ComputeHash(Encoding.UTF8.GetBytes(someString))).Replace("-", "").ToLower();
        Console.WriteLine(hashedString);
    }
}