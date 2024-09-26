csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string input = "Hello, World!";
        byte[] bytes = Encoding.UTF8.GetBytes(input);

        using (var sha512 = new SHA512CryptoServiceProvider())
        {
            byte[] hashBytes = sha512.ComputeHash(bytes);
            string hash = BitConverter.ToString(hashBytes).Replace("-", "").ToLower();
            Console.WriteLine(hash);
        }
    }
}