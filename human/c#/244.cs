csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string message = "[1312701386,transactioncreate,[account_code:ABC,amount_in_cents:5000,currency:USD]]";
        string privateKey = "0123456789ABCDEF0123456789ABCDEF";

        byte[] keyBytes = SHA1.Create().ComputeHash(Encoding.UTF8.GetBytes(privateKey));

        HMACSHA1 hmac = new HMACSHA1(keyBytes);
        byte[] result = hmac.ComputeHash(Encoding.ASCII.GetBytes(message));

        Console.WriteLine("  Message: " + message);
        Console.WriteLine("      Key: " + privateKey + "\n");
        Console.WriteLine("Key Bytes: " + BitConverter.ToString(keyBytes).Replace("-", "").ToLower());
        Console.WriteLine("  Results: " + BitConverter.ToString(result).Replace("-", "").ToLower());
    }
}