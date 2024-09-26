csharp
using System;
using System.Security;

class Program
{
    static void Main()
    {
        var s = new SecureString();
        s.AppendChar('d');
        s.AppendChar('u');
        s.AppendChar('m');
        s.AppendChar('b');
        s.AppendChar('p');
        s.AppendChar('a');
        s.AppendChar('s');
        s.AppendChar('s');
        s.AppendChar('w');
        s.AppendChar('d');
        s.MakeReadOnly();
        Console.WriteLine(s.ToString());
    }
}