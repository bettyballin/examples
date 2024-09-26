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

        using (SHA256CryptoServiceProvider sha256 = new SHA256CryptoServiceProvider())
        {
            byte[] hash = sha256.ComputeHash(bytes);

            Console.WriteLine(BitConverter.ToString(hash).Replace("-", "").ToLower());
        }
    }
}