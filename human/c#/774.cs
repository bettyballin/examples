csharp
using System;
using System.Runtime.InteropServices;
using System.Security;

class Program
{
    static void Main()
    {
        var outString = new SecureString();
        outString.AppendChar('p');
        outString.AppendChar('a');
        outString.AppendChar('s');
        outString.AppendChar('s');
        outString.AppendChar('w');
        outString.AppendChar('o');
        outString.AppendChar('r');
        outString.AppendChar('d');
        var ptr = Marshal.SecureStringToCoTaskMemUnicode(outString);

        var inString = new SecureString();
        var i = 0;
        short c;

        while ((c = Marshal.ReadInt16(ptr, i)) != 0)
        {
            inString.AppendChar((char)c);
            i += 2;
        }

        Marshal.ZeroFreeCoTaskMemUnicode(ptr);

        Console.WriteLine("Input string: ");
        using (var insecureString = new System.IO.StringWriter())
        {
            foreach (var character in inString)
            {
                insecureString.Write(character);
            }
            Console.WriteLine(insecureString.ToString());
        }
    }
}