Here is the executable C# code:

csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        string someSecret = "Some Secret To Be Hashed";
        string encodedHash = null;

        try
        {
            using (var md5 = MD5.Create())
            {
                var bytes = Encoding.UTF8.GetBytes(someSecret);
                var hashBytes = md5.ComputeHash(bytes);
                encodedHash = Convert.ToBase64String(hashBytes);
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }

        Console.WriteLine("Encoded Hash: " + encodedHash);
    }
}