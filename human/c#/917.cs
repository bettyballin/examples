csharp
using System;
using System.Security;

class Program
{
    static void Main()
    {
        string escaped = "Hello, World!";
        string unescaped = System.Security.SecurityElement.FromString($"&lt;x&gt;{escaped}&lt;/x&gt;").Text;
        Console.WriteLine(unescaped);
    }
}