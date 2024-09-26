csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string email = "your_email@example.com";
        byte[] result = System.Text.Encoding.UTF8.GetBytes(email);
        email = Convert.ToBase64String(result);
        Console.WriteLine(email);
    }
}