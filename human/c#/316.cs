csharp
using System;
using System.Text;

public class Program
{
    public static void Main()
    {
        string data = "Hello, World!";
        byte[] enc = Encoding.UTF8.GetBytes(data);
        string base64 = Convert.ToBase64String(enc);
        Console.WriteLine(base64);

        byte[] dec = Convert.FromBase64String(base64);
        string original = Encoding.UTF8.GetString(dec);
        Console.WriteLine(original);
    }
}