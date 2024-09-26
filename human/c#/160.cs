csharp
using System;
using System.Security.Cryptography;
using System.Text;
using System.Linq;

public class Program
{
    static bool VerifyIntegrity(string secret, string checksum, string data)
    {
        // Verify HMAC-SHA256 Checksum
        byte[] key = Encoding.UTF8.GetBytes(secret);
        byte[] value = Encoding.UTF8.GetBytes(data);
        byte[] checksumBytes = Convert.FromBase64String(checksum);
        using (var hmac = new HMACSHA256(key))
        {
            byte[] expectedBytes = hmac.ComputeHash(value);
            return checksumBytes.SequenceEqual(expectedBytes);
        }
    }

    public static void Main()
    {
        string secret = "my_secret_key";
        string data = "Hello, World!";
        string checksum = Convert.ToBase64String(new HMACSHA256(Encoding.UTF8.GetBytes(secret)).ComputeHash(Encoding.UTF8.GetBytes(data)));

        Console.WriteLine("Checksum: " + checksum);
        Console.WriteLine("Is Valid: " + VerifyIntegrity(secret, checksum, data));
    }
}