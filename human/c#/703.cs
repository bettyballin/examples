csharp
using System;

class Program
{
    static void Main()
    {
        string hashString = "your_base64_string_here";
        var bytes =  Convert.FromBase64String(hashString);
        Console.WriteLine(BitConverter.ToString(bytes));
    }
}