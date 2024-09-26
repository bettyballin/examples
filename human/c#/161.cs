csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main()
    {
        string secret = "my_secret_key";
        string checksum = "my_checksum";
        string data = "my_data";

        bool isValid = VerifyIntegrity(secret, checksum, data);
        Console.WriteLine($"Is checksum valid? {isValid}");
    }

    static bool VerifyIntegrity(string secret, string checksum, string data)
    {
        // Verify HMAC-SHA256 Checksum
        byte[] key = Encoding.UTF8.GetBytes(secret);
        byte[] value = Encoding.UTF8.GetBytes(data);
        using (var hmac = new HMACSHA256(key))
        {
            return checksum == Convert.ToBase64String(hmac.ComputeHash(value));
        }
    }
}