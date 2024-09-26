csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        Byte[] result = { 12, 34, 56, 78, 90 };
        StringBuilder Sb = new StringBuilder();
        foreach (Byte b in result)
            Sb.Append(b.ToString("x2"));
        Console.WriteLine(Sb.ToString());
    }
}