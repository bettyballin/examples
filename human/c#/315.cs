csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string Data = "Hello, World!";
        byte[] data = Encoding.ASCII.GetBytes(Data);
        byte[] enc = data;
        string result = ASCIIEncoding.ASCII.GetString(enc);
        Console.WriteLine(result);
    }
}