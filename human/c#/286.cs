csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string salt = "123";
        SHA1 sha = SHA1.Create();
        byte[] preHash = Encoding.UTF8.GetBytes(salt);
        byte[] hash = sha.ComputeHash(preHash);

        string password = Convert.ToBase64String(hash);
        password = password.Substring(0, 8);

        Console.WriteLine(password);
    }
}