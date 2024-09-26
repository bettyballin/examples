csharp
using System;
using System.Collections.Generic;
using System.Security;

class Program
{
    static void Main()
    {
        SecureString secureString = new SecureString();
        "fizzbuzz".ToCharArray().ToList().ForEach(p => secureString.AppendChar(p));
        Console.WriteLine(secureString.ToString());
    }
}