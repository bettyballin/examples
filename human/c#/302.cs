csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        string text = "Hello";
        Console.WriteLine("ASCIIEncoding bytes length: {0}", new ASCIIEncoding().GetBytes(text).Length);
        Console.WriteLine("UnicodeEncoding bytes length: {0}", new UnicodeEncoding().GetBytes(text).Length);
    }
}