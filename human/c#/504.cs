csharp
using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static string HashValue(string value)
    {
        string digest = null;
        try
        {
            using (var md5 = MD5.Create())
            {
                byte[] hash = md5.ComputeHash(Encoding.Unicode.GetBytes(value));
                return Convert.ToBase64String(hash);
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
        }
        return null;
    }

    public static void Main()
    {
        Console.WriteLine(HashValue("test"));
    }
}