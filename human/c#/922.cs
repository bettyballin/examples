csharp
using System;
using System.Text;

public class Program
{
    static byte[] FromBase64String(string base64)
    {
        return Convert.FromBase64String(base64);
    }

    public static void Main()
    {
        string encoded = "PHNjcmlwdD5hbGVydCgiSGVsbG8iKTs8L3NjcmlwdD4=";
        byte[] decoded = FromBase64String(encoded);
        Console.WriteLine(Encoding.UTF8.GetString(decoded));
    }
}