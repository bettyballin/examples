csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string stringPasswordForExample = "password123";
        byte[] data = Encoding.UTF8.GetBytes(stringPasswordForExample);

        using (SHA512 sha512 = SHA512.Create())
        {
            byte[] hash = sha512.ComputeHash(data);
            Console.WriteLine(BitConverter.ToString(hash));
        }
    }
}