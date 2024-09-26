csharp
using System;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        string pw = "be9d3a4f1220495a96c38d36d8558365";
        byte[] salt = new byte[0];
        int iterations = 1024;

        Rfc2898DeriveBytes pbkdf2 = new Rfc2898DeriveBytes(pw, salt, iterations);
        byte[] key = pbkdf2.GetBytes(16);

        Console.WriteLine(BitConverter.ToString(key));
    }
}