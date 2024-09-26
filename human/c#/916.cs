csharp
using System;
using System.Security;
using System.Net;

class Program
{
    static void Main()
    {
        string original = "M&amp;M";
        string escaped = SecurityElement.Escape(original);
        string unescaped = WebUtility.HtmlDecode(escaped);

        Console.WriteLine("Original: " + original);
        Console.WriteLine("Escaped: " + escaped);
        Console.WriteLine("Unescaped: " + unescaped);
    }
}