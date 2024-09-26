csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string input = "Hello, World!";
        byte[] inputBytes = Encoding.UTF8.GetBytes(input);
        using (SHA256 sha256 = SHA256.Create())
        {
            byte[] computedHash = sha256.ComputeHash(inputBytes);
            string computedHashString = Convert.ToBase64String(computedHash);
            Console.WriteLine(computedHashString);
        }
    }
}