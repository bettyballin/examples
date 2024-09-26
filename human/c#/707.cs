csharp
using System;
using System.Text;

class Program
{
    static void Main()
    {
        byte[] data = Encoding.ASCII.GetBytes("foobar");
        var base64_text = Convert.ToBase64String(data);
        Console.WriteLine(base64_text);

        data = Encoding.ASCII.GetBytes(base64_text);
        base64_text = Convert.ToBase64String(data);
        Console.WriteLine(base64_text);
    }
}