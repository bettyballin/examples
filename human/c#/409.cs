csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        var salt = new byte[32];
        using (var rng = RandomNumberGenerator.Create())
        {
            rng.GetBytes(salt);
        }

        var length = 32; // Specify the length of the key
        var key = new Rfc2898DeriveBytes("passphrase", salt, 1000).GetBytes(length);

        Console.WriteLine(BitConverter.ToString(key));
    }
}