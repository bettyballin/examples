csharp
using System;
using System.Security.Cryptography;
using System.Text;

class Program
{
    static void Main()
    {
        string text = "your_base64_string_here";
        byte[] rm_IV = Convert.FromBase64String(ASCIIEncoding.UTF8.GetString(Convert.FromBase64String(text)).Split(',')[0]);
        Console.WriteLine(BitConverter.ToString(rm_IV));
    }
}