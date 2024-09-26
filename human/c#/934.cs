csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        Console.WriteLine(Hash("hello"));
        Console.WriteLine(Hash("hello" + "QxLUF1bgIAdeQX"));
        Console.WriteLine(Hash("hello" + "bv5PehSMfV11Cd"));
    }

    static string Hash(string input)
    {
        using (var sha256 = SHA256.Create())
        {
            var bytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(input));
            var builder = new StringBuilder();
            foreach (var b in bytes)
            {
                builder.Append(b.ToString("x2"));
            }
            return builder.ToString();
        }
    }
}