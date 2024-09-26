csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        // Create a string with 5 characters
        string str = "Hello";

        // Encode the string using ASCII encoding
        byte[] asciiBytes = Encoding.ASCII.GetBytes(str);
        Console.WriteLine("ASCIIEncoding bytes length: " + asciiBytes.Length);

        // Encode the string using Unicode encoding
        byte[] unicodeBytes = Encoding.Unicode.GetBytes(str);
        Console.WriteLine("UnicodeEncoding bytes length: " + unicodeBytes.Length);
    }
}